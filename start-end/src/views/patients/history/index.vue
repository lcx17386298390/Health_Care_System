<template>
  <div class="regis-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/patient' }"
        >手续导航</el-breadcrumb-item
      >
      <el-breadcrumb-item>历史病例</el-breadcrumb-item>
    </el-breadcrumb>

    <el-card>
      <el-table :data="tableData" stripe>
        <el-table-column label="ID">
        <template slot-scope="scope">{{ scope.$index + 1 }}</template>
      </el-table-column>
        <el-table-column prop="diseaseName" label="疾病名"></el-table-column>
        <el-table-column prop="clinicDate" label="接诊时间"></el-table-column>
        <el-table-column prop="dname" label="接诊医生名字"></el-table-column>
        <el-table-column prop="department" label="科室名"></el-table-column>
      </el-table>

      <el-pagination
        :current-page="currentPage"
        :page-size="pageSize"
        :total="totalRows"
        :page-count="(currentPage - 1) * pageSize"
        @current-change="handleCurrentPageChange"
      />
    </el-card>
  </div>
</template>

<script>
import axios from "axios"
export default {
  data() {
    return {
      tableData: [], 
      currentPage: 1, 
      pageSize: 10, //一页十行
      totalRows: 0, //总行数
      patientId: JSON.parse(sessionStorage.getItem("user")).id
    };
  },
   created() {
    this.fetchData();
  },
  //模拟数据
  // created() {
  //   this.allData = [
  //     {
  //       id: 1,
  //       diseaseName: "Headache",
  //       clinicDate: "2023-07-01",
  //       dname: "Dr. Smith",
  //       department: "Neurology",
  //     },
  //     {
  //       id: 2,
  //       diseaseName: "Fever",
  //       clinicDate: "2023-07-02",
  //       dname: "Dr. Johnson",
  //       department: "Internal Medicine",
  //     },
  //     {
  //       id: 3,
  //       diseaseName: "Fever",
  //       clinicDate: "2023-07-02",
  //       dname: "Dr. Johnson",
  //       department: "Internal Medicine",
  //     },
  //     {
  //       id: 4,
  //       diseaseName: "Fever",
  //       clinicDate: "2023-07-02",
  //       dname: "Dr. Johnson",
  //       department: "Internal Medicine",
  //     },
  //     {
  //       id: 5,
  //       diseaseName: "Fever",
  //       clinicDate: "2023-07-02",
  //       dname: "Dr. Johnson",
  //       department: "Internal Medicine",
  //     },
  //     {
  //       id: 6,
  //       diseaseName: "Fever",
  //       clinicDate: "2023-07-02",
  //       dname: "Dr. Johnson",
  //       department: "Internal Medicine",
  //     },
  //     {
  //       id: 7,
  //       diseaseName: "Fever",
  //       clinicDate: "2023-07-02",
  //       dname: "Dr. Johnson",
  //       department: "Internal Medicine",
  //     },
  //     {
  //       id: 8,
  //       diseaseName: "Fever",
  //       clinicDate: "2023-07-02",
  //       dname: "Dr. Johnson",
  //       department: "Internal Medicine",
  //     },
  //     {
  //       id: 9,
  //       diseaseName: "Fever",
  //       clinicDate: "2023-07-02",
  //       dname: "Dr. Johnson",
  //       department: "Internal Medicine",
  //     },
  //     {
  //       id: 10,
  //       diseaseName: "Fever",
  //       clinicDate: "2023-07-02",
  //       dname: "Dr. Johnson",
  //       department: "Internal Medicine",
  //     },
  //     {
  //       id: 11,
  //       diseaseName: "Fever",
  //       clinicDate: "2023-07-02",
  //       dname: "Dr. Johnson",
  //       department: "Internal Medicine",
  //     },
  //     {
  //       id: 12,
  //       diseaseName: "Fever",
  //       clinicDate: "2023-07-02",
  //       dname: "Dr. Johnson",
  //       department: "Internal Medicine",
  //     },
  //   ];

  //   this.totalRows = this.allData.length;
  //   this.updateTableData();
  // },
  methods: {
    fetchData() {
      axios({
        url: 'http://localhost:8001/diseaseInfo', //api地址接口
        method: 'GET',
        params: {
          pageNo: this.currentPage,
          pageSize: this.pageSize,
          patientId: this.patientId
        }
      }).then(response => {
          this.tableData = response.data.data;
          this.totalRows = this.tableData.length;
          this.updateTableData();
        })
        .catch(error => {
          console.error('Error fetching data:', error);
        });
    },
    //分页id是自增的
    handleCurrentPageChange(currentPage) {
      this.currentPage = currentPage;
      this.updateTableData();
    },
    updateTableData() {
      const startIndex = (this.currentPage - 1) * this.pageSize;
      const endIndex = startIndex + this.pageSize;
      this.tableData = this.allData.slice(startIndex, endIndex);
    },
  },
  // mounted() {
  //   this.currentPage = 1;
  //   this.pageSize = 1;
  //   this.fetchData();
  // }
};
</script>

<style>
</style>