<template>
  <div class="container-fluid px-4 aaa">
    <h1 class="mt-2">诊断记录</h1>
    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <router-link to="/doc/his">诊断记录</router-link>
      </li>
      <li class="breadcrumb-item active">历史记录</li>
    </ol>
    <div class="card mb-4 aa">
      <div class="card-header">接诊记录</div>

      <div class="card-body">
        <div class="datatable-wrapper d-flex flex-column">
          <div class="datatable-top d-flex justify-content-between">
            <div class="d-flex justify-content-between">
              <div class="datatable-dropdown">
                <label>
                  <select
                    class="datatable-selector"
                    v-model="perPage"
                    @change="handleRowsPerPageChange"
                  >
                    <option value="5">5</option>
                    <option value="10">10</option>
                    <option value="15">15</option>
                  </select>
                  折叠条数显示
                </label>
              </div>
            </div>
            <div class="datatable-search">
              <input
                class="datatable-input"
                v-model="searchQuery"
                @input="handleSearch"
                placeholder="Search..."
                type="search"
                title="Search within table"
                aria-controls="datatablesSimple"
              />
            </div>
          </div>
          <div class="datatable-container">
            <el-table
              :data="histories"
              stripe
              style="max-height: 400px; overflow-y: auto"
              @row-click="toggleAccordion"
            >
              <el-table-column type="expand">
                <template slot-scope="props">
                  <el-form
                    label-position="left"
                    inline
                    class="demo-table-expand"
                  >
<!--                    <el-form-item label="患者id">-->
<!--                      <span>{{ props.row.patientId }}</span>-->
<!--                    </el-form-item>-->
<!--                    <el-form-item label="患有疾病">-->
<!--                      <span>{{ props.row.diseaseName }}</span>-->
<!--                    </el-form-item>-->
                    <el-form-item label="诊断医生">
<!--                      <span>{{ props.row.doctorName }}</span>-->
                      <span>{{currentDoctorName}}</span>
                    </el-form-item>
                    <el-form-item label="诊断日期">
                      <span>{{ props.row.appointmentDate }}</span>
                    </el-form-item>
                    <el-form-item label="预约科室">
                      <span>{{ props.row.appointmentDepartment }}</span>
                    </el-form-item>
                  </el-form>
                </template>
              </el-table-column>

              <el-table-column label="接诊日期" prop="appointmentDate">
              </el-table-column>
              <el-table-column
                label="患者名字"
                prop="patientName"
              ></el-table-column>
<!--              <el-table-column-->
<!--                label="患有疾病"-->
<!--                prop="diseaseName"-->
<!--              ></el-table-column>-->
              <el-table-column
                label="诊断科室"
                prop="appointmentDepartment"
              ></el-table-column>
            </el-table>
          </div>
        </div>
        <div class="datatable-bottom">
          <div class="datatable-info">
            Showing {{ startIndex }} to {{ endIndex }} of
            {{ totalEntries }} entries
          </div>
          <nav class="datatable-pagination">
            <ul class="datatable-pagination-list">
              <li
                v-if="currentPage > 1"
                @click="setCurrentPage(currentPage - 1)"
              >
                <a class="datatable-pagination-list-item-link">‹</a>
              </li>
              <li
                v-for="page in totalPages"
                :key="page"
                :class="{ 'datatable-active': currentPage === page }"
                @click="setCurrentPage(page)"
              >
                <a class="datatable-pagination-list-item-link">{{ page }}</a>
              </li>
              <li
                v-if="currentPage < totalPages"
                @click="setCurrentPage(currentPage + 1)"
              >
                <a class="datatable-pagination-list-item-link">›</a>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import axios from "axios";
export default {
   props: {
    realname: String,
  },
  data() {
    return {
      histories: [],
      perPage: 10,
      currentPage: 1,
      searchQuery: "",
      currentDoctorName: "医生二"
    };
  },
  created() {
     if (this.currentDoctorName) {
      this.fetchTableData();
    };
  },
  computed: {
    ...mapState(["realname"]),
    paginatedOrders() {
      const start = (this.currentPage - 1) * this.perPage;
      const end = start + this.perPage;
      if (this.searchQuery) {
        const lowercaseQuery = this.searchQuery.toLowerCase();
        return this.histories
          .filter(
            (order) =>
              order.patientName.toLowerCase().includes(lowercaseQuery) ||
              order.appointmentappointmentDepartment
                .toLowerCase()
                .includes(lowercaseQuery)
          )
          .slice(start, end);
      } else {
        return this.histories.slice(start, end);
      }
    },
    totalEntries() {
      return this.histories.length;
    },
    totalPages() {
      return Math.ceil(this.totalEntries / this.perPage);
    },
    startIndex() {
      return (this.currentPage - 1) * this.perPage + 1;
    },
    endIndex() {
      return Math.min(this.currentPage * this.perPage, this.totalEntries);
    },
  },
  methods: {
    handleRowsPerPageChange() {},
    setCurrentPage(page) {
      this.currentPage = page;
    },
    handleSearch() {
      this.currentPage = 1;
    },
    formattedDate(dateString) {
      const [date, timeRange] = dateString.split(" ");
      const [startTime, endTime] = timeRange.split("-");
      return `${date} ${startTime}-${endTime}`;
    },
    fetchTableData() {
      axios({
        url: 'http://localhost:8003/doctor/getAcceptappointmentBydname',
        method: 'get',
        params: {
          docName:this.currentDoctorName,
          pageNum:this.currentPage,
          pageSize:this.perPage
        }
      }).then((response) => {
        //console.log(response.data.data);
          this.histories = response.data.data;
        })
        .catch((error) => {
          console.error("Error fetching data:", error);
          this.$message.error("获取数据失败");
        });
      //案例数据，不需要时请删除，并取消上方注释
      // for (let i = 0; i < 12; i++) {
      //   this.histories.push({
      //     clinicDate: "2023-07-20 09:00-10:00",
      //     patientName: "Patient " + i,
      //     diseaseName: "Random Disease " + i,
      //     appointmentDepartment: "Random appointmentDepartment " + i,
      //     patientAge: 30 + i,
      //     patientSex: i % 2 === 0 ? "Male" : "Female",
      //     patientDrugs: "Drug " + i,
      //     diseaseDesc: "Random Disease Description " + i,
      //   });
      // }
    },
    toggleAccordion(row) {
      console.log("Toggling accordion for row:", row);
      const index = this.expandedRows.indexOf(row);
      if (index > -1) {
        this.expandedRows.splice(index, 1);
      } else {
        this.expandedRows.push(row);
      }
    },
    isActive(row) {
      return this.expandedRows.includes(row);
    },
  },
};
</script>

<style scoped>
@media screen and (max-width: 768px) {
  /* Adjust the table font size for smaller screens */
  .table-bordered th,
  .table-bordered td {
    font-size: 12px;
  }
}
.demo-table-expand {
  font-size: 0;
  margin-left: 50px;
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
.datatable-wrapper {
  /* Add overflow property to handle content overflow */
  overflow: auto;
}
.datatable-container {
  margin-top: 20px;
  border: 1px solid #ebeef5;
  border-radius: 4px;
}
.aa {
  max-height: 80%;
}
.aaa {
  height: 100vh;
}
.datatable-top > nav:last-child,
.datatable-top > div:last-child,
.datatable-bottom > nav:last-child,
.datatable-bottom > div:last-child {
  float: right;
}
.datatable-pagination li {
  list-style: none;
  float: left;
}
.datatable-pagination a {
  border: 1px solid transparent;
  float: left;
  margin-left: 2px;
  padding: 6px 12px;
  position: relative;
  text-decoration: none;
  color: #333;
  cursor: pointer;
}
.datatable-selector {
  padding: 0.375rem 1.75rem 0.375rem 0.75rem;
  height: 2.25rem;
  font-size: 0.875rem;
  border-radius: 0.375rem;
  border: 1px solid #ced4da;
  appearance: none;
  background-repeat: no-repeat;
  background-position: right 0.75rem center;
  background-size: 8px 10px;
}
.datatable-input {
  float: right;
  padding: 0.375rem 1.55rem 0.375rem 0.75rem;
  height: 2.25rem;
  font-size: 0.875rem;
  border-radius: 0.375rem;
  border: 1px solid #ced4da;
}
.table-bordered th,
.table-bordered td {
  border: 1px solid #dee2e6;
  padding: 0.55rem;
  background-color: #f7f9fb;
  text-align: center;
}
.table-bordered tr:hover {
  cursor: pointer;
}
.datatable-info {
  float: left;
}

.datatable-pagination {
  float: right;
}

.datatable-pagination-list {
  list-style: none;
  padding-left: 0;
  margin: 0;
  display: flex;
}
</style>