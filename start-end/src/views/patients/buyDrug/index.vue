<template>
  <div class="buy-container" >
    <el-row type="flex" class="row-bg" justify="space-around">
  <el-col :span="14">
    <div class="grid-content bg-purple-light flex column center">
      <div class="flex column">
        <div class="flex jst">
          <div class="title1">
         购买药品
        </div> 
        <div class="buying">
         <el-button type="success" plain @click="open(tableData)">去支付</el-button>
        </div>
        </div>
        <el-input
    placeholder="请输入药品名称或id关键字"
    prefix-icon="el-icon-search"
    v-model="search" style="width:40%;margin:2% 5%;margin-bottom:1%;margin-top:1%;">
  </el-input>
      </div>
      <el-table
    :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase())||data.id.toLowerCase().includes(search.toLowerCase()))"
    max-height="750px"
    style="width: 90%;margin-left:5%;margin-bottom:10px;">
    <el-table-column type="expand">
      <template v-slot='props'>
        <el-form label-position="left" inline class="demo-table-expand" style="padding:0 10px;">
          <el-form-item label="药品名称">
            <span>{{ props.row.name }}</span>
          </el-form-item>
          <el-form-item label="价格">
            <span>{{ props.row.price }}</span>
          </el-form-item>
          <el-form-item label="药品 ID">
            <span>{{ props.row.id }}</span>
          </el-form-item>
          <el-form-item label="库存数量">
            <span>{{ props.row.amount }}</span>
          </el-form-item>
          <el-form-item label="药品用法">
            <span>{{ props.row.usage }}</span>
          </el-form-item>
          <el-form-item label="药品描述">
            <span>{{ props.row.desc }}</span>
          </el-form-item>
          
        </el-form>
      </template>
    </el-table-column>

    <el-table-column
      label="药品 ID"
      prop="id">
    </el-table-column>
    <el-table-column
      label="药品名称"
      prop="name">
    </el-table-column>
    <el-table-column
      label="价格"
      prop="price">
    </el-table-column>
    <el-table-column
      label="加入购物车"
      prop="buyNum">
      <template v-slot="scoped"> 
         <el-input-number v-model="scoped.row.buyNum" @change="handleChange(scoped)" :min="0" :max="scoped.row.amount" label="药品数量" size="mini"></el-input-number>
      </template>
    </el-table-column>
    <el-table-column
      label="清空">
      <template v-slot="scoped"> 
         <el-button type="danger" icon="el-icon-delete" circle size="mini" @click="clear(scoped)"></el-button>
      </template>
    </el-table-column>

  </el-table>
  <div class="block" style="margin-left:28%;margin-bottom:10px;">
  <el-pagination
    layout="prev, pager, next"
    :total="1000">
  </el-pagination>
</div>
    </div>

    </el-col>
  <el-col :span="8"><div class="grid-content bg-purple">
    
    </div></el-col>
</el-row>
    </div>
</template>

<script>
export default {
   data() {
      return {
        search:'',
        tableData: [{
          id: '111',
          name: '止咳片',
          price:'50￥',
          desc: '白色片剂，味微苦，无副作用（真）',
          amount:10,
          usage:'一日三次，一次两粒',
          buyNum:0
        },
        {
          id: '112',
          name: '止疼片',
          price:'50￥',
          desc: '白色片剂，味微苦，无副作用（真）',
          amount:1,
          usage:'一日三次，一次两粒',
          buyNum:0
        },
        {
          id: '113',
          name: '止血片',
          price:'50￥',
          desc: '白色片剂，味微苦，无副作用（真）',
          amount:1000,
          usage:'一日三次，一次两粒',
          buyNum:0
        },
        {
          id: '114',
          name: '止片',
          price:'50￥',
          desc: '白色片剂，味微苦，无副作用（真）',
          amount:1000,
          usage:'一日三次，一次两粒',
          buyNum:0
        },
        {
          id: '115',
          name: '止饿片',
          price:'50￥',
          desc: '白色片剂，味微苦，无副作用（真）',
          amount:1000,
          usage:'一日三次，一次两粒',
          buyNum:0
        },
        {
          id: 'xxx',
          name: '？？片',
          price:'99999999999999￥',
          desc: '无色无味，无副作用（真）',
          amount:10,
          usage:'一日三次，一次两粒',
          buyNum:0
        }]
      }
    },
    methods: {
      handleChange(value) {
        if(value.row.amount===value.row.buyNum){
          this.$message({
            message:"没有库存了！！!",
            type:'warning'
          })
        }
      },
      clear(scoped){
        scoped.row.buyNum=0;
      },
      open(data){
        data=data.filter(data=>data.buyNum>0)
        
      }
    }

}
</script>

<style scoped>
.el-row {
    margin-bottom: 20px;
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 20px 0;
    background-color: #f9fafc7b;
    height: 94vh;
    margin: 10px;
    margin-top:20px;
    border: 1px solid rgba(123, 123, 123, 0.235);
    border-radius: 6px;
  }


  /* 药品列表 */
    .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }



/* 购买药品小标题 */
.title1{
  background-color: rgba(46, 67, 202, 0.199);
  width: 80px;
  height: 30px;
  text-align: center;
  padding-top:4px;
  margin-left:10px;
  margin-top: 10px;
  border-radius: 4px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
}
.buying{
  background-color:transparent;
  margin-right:10px;
  margin-top: 20px;
}

/* 布局 */
  .flex{
    display: flex;
  }
  .column{
    flex-direction: column;
  }
  .center{
    justify-content: center;
  }
  .jst{
    justify-content: space-between;
  }
</style>