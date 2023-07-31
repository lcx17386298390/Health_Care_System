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
              <span slot="label" prop="drugs" class="tian">患病详情</span>
              <el-input type="textarea" :rows="2" v-model="ruleForm.drugs"></el-input>
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

import axios from 'axios'
<script>
export default {
  name: "drug0",
  data () {
    return {
      pname: '',
      dname: '',
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
      }
    }
  },
}
</script>

<style scoped>
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