<template>
  <div class="container-fluid px-4 aaa">
    <h1 class="mt-2">订单处理</h1>
    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <router-link to="/doc/order">订单</router-link>
      </li>
      <li class="breadcrumb-item active">表格</li>
    </ol>
    <div class="card mb-4 aa">
      <div class="card-header">预约订单列表</div>
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
              :data="paginatedOrders"
              stripe
              style="max-height: 400px; overflow-y: auto"
            >
              <el-table-column label="预约日期" prop="appointmentDate">
                <template #default="{ row }">{{
                  formattedDate(row.appointmentDate)
                }}</template>
              </el-table-column>
              <el-table-column
                label="患者名字"
                prop="patientName"
              ></el-table-column>
              <el-table-column
                label="预约科室"
                prop="appointmentDepartment"
              ></el-table-column>
              <el-table-column label="预约状态" prop="appointmentStatus">
                <template #default="{ row }">
                  <el-popover
                    ref="popover"
                    trigger="hover"
                    placement="top-start"
                    width="200"
                  >
                    <template #reference>
                      <el-button :type="getButtonType(row.appointmentStatus)">
                        {{ row.appointmentStatus }}
                      </el-button>
                    </template>
                    <p style="margin-bottom: 10px">确认接取订单</p>
                    <div>
                      <el-button
                        type="success"
                        size="mini"
                        @click="confirmStatus(row, '通过')"
                      >
                        确认
                      </el-button>
                      <el-button type="info" size="mini" @click="cancelStatus">
                        取消
                      </el-button>
                    </div>
                  </el-popover>
                </template>
              </el-table-column>
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
import axios from "axios";
export default {
  components: {},
  data() {
    return {
      orders: [
        {
          appointmentDate: "",
          patientName: "",
          appointmentDepartment: "",
          appointmentStatus: "",
        },
      ],
      perPage: 10,
      currentPage: 1,
      searchQuery: "",
      currentDoctorName: "医生二"

    };
  },
  created() {
    this.fetchTableData();
  },
  computed: {
    paginatedOrders() {
      const start = (this.currentPage - 1) * this.perPage;
      const end = start + this.perPage;
      if (this.searchQuery) {
        const lowercaseQuery = this.searchQuery.toLowerCase();
        return this.orders
          .filter(
            (order) =>
              order.patientName.toLowerCase().includes(lowercaseQuery) ||
              order.appointmentDepartment.toLowerCase().includes(lowercaseQuery)
          )
          .slice(start, end);
      } else {
        return this.orders.slice(start, end);
      }
    },
    totalEntries() {
      return this.orders.length;
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
    getButtonType(appointmentStatus) {
      return appointmentStatus === "等待接收" ? "danger" : "success";
    },

    async fetchTableData() {
      try {
        const response = await axios({
          url: 'http://localhost:8003/doctor/getappointmentBydname',
          method: 'get',
          params:{
            docName:this.currentDoctorName,
            pageNum:this.currentPage,
            pageSize:this.perPage
          }
        })//api写这里
        this.orders = response.data.data;
      } catch (error) {
        this.$message.error("获取数据失败");
      }
    },
    async confirmStatus(order, status) {
      //console.log(order.id)
      try {
        const response = await axios({
          url: 'http://localhost:8003/doctor/appointstatus',
          method:'post',
          params:{
            orderId:order.id,
            status:status
          }
        })
        if (response.status === 200) {
          console.log(response.data)
          order.appointmentStatus = status;
          this.$notify({
            title: "成功",
            message: "已接取预约订单，请按时接诊！",
            type: "success",
          });
        } else {
          this.$notify.error("更新数据失败");
        }
      } catch (error) {
        this.$notify.error("更新数据失败");
      }
      this.$refs.popover.hide();
    },

    cancelStatus() {
      this.$notify({
        title: "消息",
        message: "已取消操作",
        type: "info",
      });
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
