<template>
  <div class="regis-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/patient/nav' }"
        >手续导航</el-breadcrumb-item
      >
      <el-breadcrumb-item>排队挂号</el-breadcrumb-item>
    </el-breadcrumb>

    <transition name="el-fade-in">
      <el-card
        class="box-card mt-4 border-left-primary slide-in"
        shadow="hover"
      >
        <div slot="header" class="clearfix">
          <span>挂号流程</span>
        </div>
        <el-form>
          <el-form-item label="门诊科室"
            ><hr />
            <el-radio-group v-model="selectedDepartment">
              <el-radio label="内科">内科</el-radio>
              <el-radio label="外科">外科</el-radio>
              <el-radio label="儿科">儿科</el-radio>
              <el-radio label="妇科">妇科</el-radio>
              <el-radio label="眼科">眼科</el-radio>
              <el-radio label="耳鼻喉科">耳鼻喉科</el-radio>
              <el-radio label="口腔科">口腔科</el-radio>
              <el-radio label="皮肤科">皮肤科</el-radio>
              <el-radio label="中医科">中医科</el-radio>
              <el-radio label="针灸推拿科">针灸推拿科</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-form>
        <el-button
          v-if="currentStep === 1"
          style="margin-left: 43%"
          @click="next"
          >下一步</el-button
        >
      </el-card>
    </transition>

    <transition name="slide-down">
      <el-card
        v-if="currentStep === 2"
        class="box-card mt-4 border-left-primary"
        shadow="hover"
      >
        <hr />
        <el-form :model="formData" ref="form" :rules="formRules">
          <el-row>
            <el-col :span="12">
              <el-form-item label="选择预约时间" prop="selectedTime">
                <el-date-picker
                  v-model="formData.selectedTime"
                  type="date"
                  :picker-options="pickerOptions"
                  placeholder="选择预约时间"
                  @change="handleDateChange"
                  format="yyyy/MM/dd"
                  value-format="yyyy/MM/dd"
                ></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12" v-if="isDateSelected">
              <el-form-item label="选择时间段" prop="selectedTimeSlot">
                <el-select
                  v-model="formData.selectedTimeSlot"
                  placeholder="请选择时间段"
                >
                  <el-option
                    v-for="slot in availableTimeSlots"
                    :key="slot"
                    :label="slot"
                    :value="slot"
                  ></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>

          <el-form-item
            v-if="isDateSelected && formData.selectedTimeSlot"
            label="此时间段空闲医生"
            prop="selectedDoctor"
          >
            <el-select
              v-model="formData.selectedDoctor"
              placeholder="请选择医生"
            >
              <el-option
                v-for="doctor in doctorOptions"
                :key="doctor"
                :label="doctor"
                :value="doctor"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <el-button
          v-if="currentStep === 2"
          style="margin-left: 43%"
          @click="next"
          >提交</el-button
        >
      </el-card>
    </transition>

    <el-dialog
      :visible="showModal"
      :before-close="handleModalClose"
      title="挂号信息"
    >
      <ul>
        <li v-for="(item, index) in modalData" :key="index">
          <p>单号：{{ item.aid }}</p>
          <p>预约时间：{{ item.selectedTime }} {{ item.selectedTimeSlot }}</p>
          <p>患者姓名：{{ item.realname }}</p>
          <p>性别：{{ item.sex }}</p>
          <p>年龄：{{ item.age }}</p>
          <p>科室名：{{ item.departmentname }}</p>
          <p>医生姓名：{{ item.dname }}</p>
        </li>
      </ul>
    </el-dialog>
  </div>
</template>

<script>

import axios from "axios"
export default {
  data() {
    return {
      currentStep: 1,
      selectedDepartment: "",
      showStep2: false,
      selectedDoctor: "",
      patientName: JSON.parse(sessionStorage.getItem("user")).username,
      doctorOptions: ["医生一","医生二","医生三"],
      formData: {
        selectedDoctor: "",
      },
      formRules: {
        selectedDoctor: [
          { required: true, message: "请选择医生", trigger: "blur" },
        ],
        selectedTime: [
          { required: true, message: "请选择预约时间", trigger: "blur" },
        ],
      },
      showModal: false,
      modalData: [],
      disableTimePicker: true,
      pickerOptions: {
        disabledDate: (time) => {
          const today = new Date();
          today.setHours(0, 0, 0, 0);
          const oneWeekFromToday = new Date(today);
          oneWeekFromToday.setDate(today.getDate() + 6);
          return (
            time.getTime() < today.getTime() ||
            time.getTime() > oneWeekFromToday.getTime()
          );
        },
      },
      isDateSelected: false,
    };
  },
  mounted() {
    setTimeout(() => {
      this.showCard2 = true;
    }, 500);
  },
  methods: {
    async next() {
      if (this.currentStep === 1) {
        if (!this.selectedDepartment) {
          this.$message.warning("请选择科室");
          return;
        }
        this.showStep2 = true;
        this.currentStep = 2;
      } else if (this.currentStep === 2) {
        if (!this.formData.selectedTime) {
          this.$message.error("请选择预约时间");
          return;
        }
        if (!this.formData.selectedTimeSlot) {
          this.$message.error("请选择时间段");
          return;
        }
        if (!this.formData.selectedDoctor) {
          this.$message.error("请选择医生");
          return;
        }
        this.showModal = true;
        // api接口写在这里
        const date = this.formData.selectedTime
        const time = this.formData.selectedTimeSlot.replace("至","-")
        const datetime = date + " " + time
        console.log(datetime)
        axios({
          url: 'http://localhost:8001/appoint',
          method: 'get',
          params:{
            appointmentDate: datetime,
            patientName: this.patientName,
            doctorName: this.formData.selectedDoctor,
          }
        }).then(resp => {
          if(resp.data.code === 200){
            // 下面模拟带回的数据,一个对象放在modalDate里,下面这个模拟数据
            this.modalData = [
              {
                aid: "1",//resp.count...
                selectedTime: this.formData.selectedTime,
                selectedTimeSlot: this.formData.selectedTimeSlot,
                realname: this.patientName,
                sex: "Male",//resp.data.data.patient.sex
                age: 21,//resp.data.data.patient.age
                departmentname: this.selectedDepartment,
                dname: this.formData.selectedDoctor,
              },
            ];
          }else{
            this.$message.error("预订失败!请稍后再试")
          }

        })
      }
    },

    handleDateChange() {
      this.isDateSelected = !!this.formData.selectedTime;
    },
    handleModalClose() {
      this.showModal = false;
      this.$message({
        type: "success",
        message: "操作成功！请耐心等待不要多次提交订单！",
        onClose: () => {
          // Refresh the current page to reset the data
          window.location.reload();
        },
      });
    },
    handleDateChange() {
      // Check if the date is selected
      if (this.formData.selectedTime) {
        this.isDateSelected = true;
        this.getAvailableTimeSlots(); // Function to get available time slots based on selected date
      } else {
        this.isDateSelected = false;
      }
    },
    getAvailableTimeSlots() {
      this.availableTimeSlots = [
        "8:00-9:00",
        "9:00-10:00",
        "10:00-11:00",
        "13:00-14:00",
        "14:00-15:00",
        "15:00-16:00",
        "16:00-17:00",
      ];
    },
  },
  computed: {
    availableTimeSlots() {
      if (!this.formData.selectedTime) return [];
      const selectedDate = new Date(this.formData.selectedTime);
      const availableSlots = [];

      selectedDate.setHours(8, 0, 0, 0);

      while (selectedDate.getHours() < 17) {
        const startTime = selectedDate.toLocaleTimeString([], {
          hour: "2-digit",
          minute: "2-digit",
        });

        selectedDate.setHours(selectedDate.getHours() + 1);

        const endTime = selectedDate.toLocaleTimeString([], {
          hour: "2-digit",
          minute: "2-digit",
        });

        availableSlots.push(`${startTime}至${endTime}`);
      }

      return availableSlots;
    },
  },
  watch: {
    selectedDepartment(newValue) {
      if (newValue) {
        this.disableTimePicker = false;
      }
    },
  },
};
</script>
<style>
.el-fade-in-enter-active,
.el-fade-in-leave-active {
  transition: opacity 1s;
}

.el-fade-in-enter,
.el-fade-in-leave-to {
  opacity: 0;
}
.slide-down-enter-active,
.slide-down-leave-active {
  transition: all 0.3s ease; /* Add a transition for smooth animation */
}

.slide-down-enter,
.slide-down-leave-to {
  transform: translateY(-100%); /* Slide down the second card */
}
.el-select {
  margin-left: 30px;
}
.regis-container {
  overflow: auto;
}
.el-card {
  margin: 55px;
}
.el-breadcrumb {
  margin-top: 25px;
}
.border-left-primary {
  /* border-left: 0.25rem solid #4e73df !important; */
  border-left: 0.25rem solid #36b9cc !important;
}
</style>