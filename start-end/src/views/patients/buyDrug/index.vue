<template>
  <div class="buy-container" >
    <el-row type="flex" class="row-bg" justify="space-around"  style="overflow:auto;">
  <el-col :span="16">
    <div class="grid-content bg-purple-light flex column center ">
      <div class="flex column">
        <div class="flex jst">
          <div class="title1">
         购买药品
        </div> 
        <div class="buying">
         <el-button type="success" plain @click="open(tableData),dialogVisible=true">去支付</el-button>
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
            <span>{{ props.row.drugName }}</span>
          </el-form-item>
          <el-form-item label="价格">
            <span>{{ props.row.drugPrice+' 元' }}</span>
          </el-form-item>
          <el-form-item label="药品 ID">
            <span>{{ props.row.id }}</span>
          </el-form-item>
          <el-form-item label="库存数量">
            <span>{{ props.row.drugNums }}</span>
          </el-form-item>
          <el-form-item label="药品用法">
            <span>{{ props.row.drugUsage }}</span>
          </el-form-item>
<!--          id: "",-->
<!--          drugName: "",-->
<!--          drugPrice: "",-->
<!--          drugNums: "",-->
<!--          drugUsage:"",-->
<!--          buyNum:0-->
          
        </el-form>
      </template>
    </el-table-column>
        <!--          id: "",-->
        <!--          drugName: "",-->
        <!--          drugPrice: "",-->
        <!--          drugNums: "",-->
        <!--          drugUsage:"",-->
        <!--          buyNum:0-->
    <el-table-column
      label="药品 ID"
      prop="id">
    </el-table-column>
    <el-table-column
      label="药品名称"
      prop="drugName">
    </el-table-column>
    <el-table-column
      label="价格"
      prop="drugPrice">
    </el-table-column>
    <el-table-column
      label="加入购物车"
      prop="buyNum">
      <template v-slot="scoped"> 
         <el-input-number v-model="scoped.row.buyNum" @change="handleChange(scoped)" :min="0" :max="scoped.row.max" label="药品数量" size="mini"></el-input-number>
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
  <el-col :span="6"><div class="grid-content bg-purple">
    
    </div></el-col>
</el-row>



<el-dialog
  title="药品清单"
  :visible.sync="dialogVisible"
  width="30%"
  >
  <!-- <ul>
    <li v-for="item in buyList" :key="item.id">{{item.name}}</li>
    <li>{{item.price}}</li>
    <li>{{item.buyNum}}</li>
  </ul> -->
  <!--          id: "",-->
  <!--          drugName: "",-->
  <!--          drugPrice: "",-->
  <!--          drugNums: "",-->
  <!--          drugUsage:"",-->
  <!--          buyNum:0-->
  <el-table :data="tableData.filter(data=>data.buyNum>0)">
    <el-table-column property="drugName" label="药品" width="150"></el-table-column>
    <el-table-column property="drugPrice" label="价格" width="200"></el-table-column>
    <el-table-column property="buyNum" label="数量"></el-table-column>
  </el-table>
  <span slot="footer" class="dialog-footer">
    <span style="padding-right:10px;">共计{{this.allPrice}}人民币</span>
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="confirmPay">确 定</el-button>
  </span>
</el-dialog>
    </div>
</template>

<script>
import axios from "axios"
export default {
   data() {
      return {
        search:'',
        dialogVisible:false,
        pageNum: 1,
        pageSize: 10,
        allPrice:0,
        max: 10,
        tableData: [{
          id: "",
          drugName: "",
          drugPrice: "",
          drugNums: "",
          drugUsage:"",
          buyNum:0
        }]
      }
    },
    methods: {
      handleChange(value) {
        if(value.row.max===value.row.buyNum){
          this.$message({
            message:"您不能一次性购买10个药品！！!",
            type:'warning'
          })
        }
      },
      clear(scoped){
        scoped.row.buyNum=0;
      },
      open(data){
        data=data.filter(data=>data.buyNum>0)
        var aaa=0
        data.forEach(function(item){
          aaa+=item.drugPrice*item.buyNum
        }
          );
        this.allPrice=aaa
      },
      clearBuyNum(data){
        data.forEach(item=>{item.amount-=item.buyNum,item.buyNum=0});
      },
      confirmPay(){
        this.dialogVisible = false
        this.clearBuyNum(this.tableData.filter(data=>data.buyNum>0))
        axios({
          url: "http://localhost:8001/payment/goAlipay",
          method: "get",
          merchantUserId: this.uuid(),
          //merchantUserId: "123456",
          merchantOrderId: this.uuid()
          //merchantOrderId: "654321"
        }).then(resp => {
          if(resp.data.status === 200){
            //新打开一个页面（about:blank是打开浏览器空白页的命令）, _blank：打开一个新的窗口
            var newPage = window.open("about:blank", "_blank");
            //将后台传过来的html页面写到新打开的浏览器窗口中显示
            newPage.document.write(resp.data.data);
          }
        })

      },
      uuid() {
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
          var r = (Math.random() * 16) | 0,
              v = c == 'x' ? r : (r & 0x3) | 0x8;
          return v.toString(16);
        });
      },
      initDrugList(){
            axios({
              url: 'http://localhost:8001/druglist',
              method: 'get',
              params: {
                pageNum: this.pageNum,
                pageSize: this.pageSize
              }
            }).then(resp => {
              console.log(resp.data.data)
                this.tableData = resp.data.data;
            })
      }
    },
    mounted() {
     this.initDrugList()
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