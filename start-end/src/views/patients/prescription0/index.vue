<template>
  <div class="prescription">

    <h3>处方单</h3>
    <span>姓名：---</span><span>医师：---</span>
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
    <h2>R:</h2>
    <el-table :data="tableData" height="300" border style="width: 100%">
    <el-table-column prop="id" label="药品ID" width="180"></el-table-column>
    <el-table-column prop="name" label="药品名称" width="180"></el-table-column>
    <el-table-column prop="price" label="价格"> </el-table-column>
    </el-table>

  </div>
</template>

<script>
export default {

  data() {
    return {
      showFullText: false,
      diagnosis: "这是一个非常长的临床诊断，超过两行文字。这是一个非常长的临床诊断，超过两行文字。这是一个非常长的临床诊断，超过两行文字。",
      truncatedDiagnosis: "",
      tableData: [{
          id: '111',
          name: '布洛芬',
          price: '99.9'
        }, {
          id: '222',
          name: '阿莫西林',
          price: '88.8'
        }, {
          id: '333',
          name: '消食片',
          price: '77.7'
        }, {
          id: '444',
          name: '含笑半步颠',
          price: '66.6'
        }, {
          id: '555',
          name: '菠菜',
          price: '55'
        }, {
          id: '666',
          name: '透骨青',
          price: '44'
        }, {
          id: '777',
          name: '哈哈哈',
          price: '22'
        }]
      
    };
  },
  mounted() {
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
