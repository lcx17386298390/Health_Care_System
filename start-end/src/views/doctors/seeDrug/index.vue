<template>
  <div style="width: 96%">
    <div class="container-fluid px-4">
      <h1 class="mt-2">查看药品</h1>
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <router-link to="/doc/see-drug">查看药品</router-link>
        </li>
        <li class="breadcrumb-item active">药品仓库</li>
      </ol>
    </div>
    <el-row>
      <el-col :span="24">
        <div class="grid-content bg-purple-light" style="padding: 20px;border-radius:10px;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)">
          <el-input
            placeholder="请输入药品名称或id关键字"
            prefix-icon="el-icon-search"
            v-model="search"
            style="width: 32%; margin: 2% 5%; margin-bottom: 1%; margin-top: 1%"
          >
          </el-input>
          <el-table
            :data="
              tableData.filter(
                (data) =>
                  !search ||
                  data.drugName.toLowerCase().includes(search.toLowerCase()) ||
                  data.id.toLowerCase().includes(search.toLowerCase())
              )
            "
            max-height="700px"
            style="width: 90%; margin-left: 5%; margin-bottom: 10px"
          >
            <el-table-column type="expand">
              <template v-slot="props">
                <el-form
                  label-position="left"
                  inline
                  class="demo-table-expand"
                  style="padding: 0 10px"
                >
                  <el-form-item label="药品 ID">
                    <span>{{ props.row.id }}</span>
                  </el-form-item>
                  <el-form-item label="药品名称">
                    <span>{{ props.row.drugName }}</span>
                  </el-form-item>
                  <el-form-item label="价格">
                    <span>{{ props.row.drugPrice + "元" }}</span>
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
            <el-table-column label="药品 ID" prop="id"> </el-table-column>
            <el-table-column label="药品名称" prop="drugName">
            </el-table-column>
            <el-table-column label="价格" prop="drugPrice"> </el-table-column>
            <el-table-column label="库存" prop="drugNums"> </el-table-column>
          </el-table>
          <div class="block" style="margin-left: 45%; margin-bottom: 10px">
            <el-pagination
              layout="prev, pager, next"
              :total="(pageNum - 1) * pageSize"
            >
            </el-pagination>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      search: "",
      pageNum: 1,
      pageSize: 10,
      max: 10,
      tableData: [
        {
          id: "1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
          drugName: "1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
          drugPrice: "1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
          drugNums: "1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
          drugUsage: "1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        }
      ],
    };
  },
};
</script>

<style scoped lang="less">
.el-row {
  margin-bottom: 20px;
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-light {
  background: #e5e9f2;
}
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
</style>