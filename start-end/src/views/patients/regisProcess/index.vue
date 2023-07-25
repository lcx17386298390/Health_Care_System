<template>
  <div class="regis-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/patient' }"
        >手续导航</el-breadcrumb-item
      >
      <el-breadcrumb-item>排队挂号</el-breadcrumb-item>
    </el-breadcrumb>

    <el-card class="box-card mt-4 border-left-primary" shadow="hover">
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
      <el-button v-if="currentStep === 1" style="margin-left: 43%" @click="next"
        >下一步</el-button
      >
    </el-card>

    <el-card
      v-if="currentStep === 2"
      class="box-card mt-4 border-left-primary"
      shadow="hover"
    >
      <hr />
      <el-form :model="formData" ref="form" :rules="formRules">
        <el-form-item label="选择医生" prop="selectedDoctor">
          <el-select v-model="formData.selectedDoctor" placeholder="请选择医生">
            <el-option
              v-for="doctor in doctorOptions"
              :key="doctor"
              :label="doctor"
              :value="doctor"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <el-button v-if="currentStep === 2" style="margin-left: 43%" @click="next"
        >提交</el-button
      >
    </el-card>
    <el-dialog
      :visible="showModal"
      :before-close="handleModalClose"
      title="挂号信息"
    >
      <ul>
        <li v-for="(item, index) in modalData" :key="index">
          <p>单号：{{ item.aid }}</p>
          <p>患者姓名：{{ item.realname }}</p>
          <p>性别：{{ item.sex }}</p>
          <p>年龄：{{ item.age }}</p>
          <p>医生姓名：{{ item.dname }}</p>
          <p>科室名：{{ item.departmentname }}</p>
        </li>
      </ul>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      currentStep: 1,
      selectedDepartment: "",
      showStep2: false,
      selectedDoctor: "",
      doctorOptions: ["医生1", "医生2", "医生3"],
      formData: {
        selectedDoctor: "",
      },
      formRules: {
        selectedDoctor: [
          { required: true, message: "请选择医生", trigger: "blur" },
        ],
      },
      showModal: false,
      modalData: [],
    };
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
        this.$refs.form.validate((valid) => {
          if (valid) {
            this.showModal = true;
            // api接口写在这里
            // 带回的数据,一个对象放在modalDate里,下面这个模拟数据
            this.modalData = [
              {
                aid: "1",
                realname: "Naruto",
                sex: "Male",
                age: 21,
                dname: this.formData.selectedDoctor,
                departmentname: this.selectedDepartment,
              },
            ];
          } else {
            this.$message.error("请选择医生");
          }
        });
      }
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
  },
};
</script>
<style>
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