<!-- 此页面为订单页面联动页面 -->
<template>
  <div>
    <div class="container-fluid px-4">
      <h1 class="mt-2">开处方</h1>
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <router-link to="/doc/drug0">处方</router-link>
        </li>
        <li class="breadcrumb-item active">诊断</li>
      </ol>
    </div>

    <!-- 卡片 -->
    <el-card class="box-card" style="margin-top: -4px;">
      <h3 class="t">处方单</h3>
      <!-- 诊断内容部分 -->
      <div>
        <!-- 病人信息部分 -->
        <div class="b">
          <el-row>
            <el-col :span="12">
              <h5>患者名称：{{ pname }}</h5>
            </el-col>
            <el-col :span="12">
              <h5>医生姓名:{{ dname }}</h5>
            </el-col>
          </el-row>
        </div>

        <!-- 临床诊断部分 -->
        <div style="margin-top: 20px;">
          <h5 style="margin-bottom: 20px;">临床诊断:</h5>

          <!-- 填写部分 -->
          <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item prop="disease_name">
              <span slot="label" class="tian">病名</span>
              <el-input v-model="ruleForm.disease_name"></el-input>
            </el-form-item>
            <el-form-item prop="disease_desc">
              <span slot="label" prop="disease_desc" class="tian">患病详情</span>
              <el-input type="textarea" :rows="2" v-model="ruleForm.disease_desc"></el-input>
            </el-form-item>

            <el-form-item prop="drugs">
              <span slot="label" prop="drugs" class="tian">药瓶信息</span>
              <div class="tags" style="display: inline;">
                <el-tag v-for="(drug, index) in drugsList" :key="index" closable @close="handleTagClose(index)">
                  {{ drug }}
                </el-tag>
              </div>
              <el-input v-if="inputVisible" class="input-new-tag" v-model="zsdrug" ref="input" size="medium"
                @keyup.enter.native="handleInputConfirm" @blur="handleInputConfirm"></el-input>
              <el-button v-else class="button-new-tag" size="small" @click="showInput">
                添加药名
              </el-button>
            </el-form-item>



            <!-- 提交和重置按钮 -->
            <el-form-item>
              <el-button type="primary" @click="submitForm">提交</el-button>
              <el-button @click="resetForm">重置</el-button>
            </el-form-item>

          </el-form>
        </div>

      </div>
    </el-card>


  </div>
</template>


<script>
import axios from 'axios'
export default {
  name: "drug0",
  data () {
    return {
      pname: 'vvv',
      dname: '医生二',
      zsdrug: "",
      inputVisible: false,
      ruleForm: {
        disease_name: '',
        disease_desc: '',
        drugs: '', // 药物列表
      },
      rules: {
        disease_name: [{ required: true, message: '请输入病名', trigger: 'blur' }],
        disease_desc: [{ required: true, message: '请输入详情', trigger: 'blur' }],
        drugs: [{ required: true, message: '请输入详情', trigger: 'blur' }],
      },


    }
  },
  computed: {
    drugsList () {
      return this.ruleForm.drugs.split(", ")
    },
  },
  methods: {
    showInput () {
      this.inputVisible = true
      this.$nextTick(() => {
        this.$refs.input.focus()
      })
    },
    handleInputConfirm () {
      let drug = this.zsdrug.trim()
      if (drug) {
        if (this.ruleForm.drugs) {
          this.ruleForm.drugs += ", "
        }
        this.ruleForm.drugs += drug
      }
      this.inputVisible = false
      this.zsdrug = ""
      alert(this.ruleForm.drugs)
    },
    handleTagClose (index) {
      const drugsList = this.ruleForm.drugs.split(", ")
      drugsList.splice(index, 1)
      this.ruleForm.drugs = drugsList.join(", ")
    },
    submitForm () {
      // 使用axios发送POST请求将数据发送到后端 API
      axios({
        url: 'http://localhost:8003/doctor/addPrescription',
        method:'post',
        params:{
          diseaseName:this.ruleForm.disease_name,
          diseaseDesc:this.ruleForm.disease_desc,
          drugs:this.ruleForm.drugs,
          dname:this.dname,
          pname:this.pname
        }
      }).then((response) => {
          // 处理成功响应
          console.log(response.data)
        })
        .catch((error) => {
          // 处理错误
          console.error(error)
        })
    },
    resetForm () {
      this.$refs.ruleForm.resetFields()
      this.ruleForm.drugs = ""
      this.zsdrug = ""
    },
  }
}
</script>

<style scoped>
.el-tag+.el-tag {
  margin-left: 10px;
}

.button-new-tag {
  margin-left: 10px;
  height: 32px;
  line-height: 30px;
  padding-top: 0;
  padding-bottom: 0;
}

.input-new-tag {
  width: 90px;
  margin-left: 10px;
  vertical-align: bottom;
}

/* 填写部分 */
.tian {
  font-size: 19px;
  font-weight: normal;
}

/* 病人信息  */
.b {
  margin-top: 30px;
}

/* 标题 */
.t {
  text-align: center;
  font-size: 30px;
  font-weight: 540;
}

/* 卡片部分 */
.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.box-card {
  width: 1100px;
  padding: 20px;
}
</style>