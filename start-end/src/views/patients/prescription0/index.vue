<template>
  <div class="prescription">

    <h3>处方单</h3>
    <span>姓名：{{username}}</span><span>医师：{{docname}}</span>
    <br>
    临床诊断：
    <div class="zhenduan">
      <div v-if="!showFullText">
        <div>{{ truncatedDiagnosis }}</div>
        <button @click="showFullText = true">--详情--</button>
      </div>
      <div v-else>
        <div>{{ diagnosis }}</div>
        <button @click="showFullText = false">--收起--</button>
      </div>
    </div>

    <hr>

    <h2>药品:</h2>
  药品名称:{{drugs}}

  </div>
</template>

<script>
import axios from "axios"
export default {

  data() {
    return {
      showFullText: false,
      diagnosis: "",
      truncatedDiagnosis: "",
      drugs: '',
      username:JSON.parse(sessionStorage.getItem("user")).username,
      docname:""
    };
  },
  methods:{
    getPrescription(){
      axios({
        url: 'http://localhost:8003/doctor/getPrescriptionByName',
        method: 'post',
        params:{
          pname:this.username
        }
      }).then(resp => {
        if(resp.data.code === 200){
          //console.log(resp.data.data.drugs)
          this.diagnosis = resp.data.data.diseaseDesc
          this.docname = resp.data.data.dname
          this.drugs = resp.data.data.drugs
          //console.log(this.drugs.name)
        }else{
          this.$message.error({
            message: resp.data.msg,
            type: 'error',
          })
        }
      })
    }
  },
  created() {
    this.getPrescription();
    if (this.diagnosis.length > 35) {
      this.truncatedDiagnosis = this.diagnosis.slice(0, 35) + '...';
    } else {
      this.truncatedDiagnosis = this.diagnosis;
    }
  }
};
</script>

<style scoped>
.prescription {
  line-height: 30px;
  margin: 15px 0 0 165px;
  width: 720px;
  height: 750px;
  background-color: #fff;
  border-radius: 6px;
  padding: 25px;
  color: rgb(68, 68, 68);
}
span:nth-child(2n) {
  margin-right: 150px;
}
h3 {
  margin: 20px 0 20px 0;
  text-align: center;
  font-weight: bold;
  color: rgb(78, 78, 78);
}
h2 {
  color: rgb(78, 78, 78);
}
.zhenduan {
  -webkit-line-clamp: 2;
  overflow: hidden;
}
button {
  font-size: 14px;
  border: none;
  border-radius: 8px;
  background-color: #fff;
  color: rgb(61, 88, 212);
}

</style>
