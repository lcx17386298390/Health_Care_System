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
            <table
              id="datatablesSimple"
              class="table table-bordered table-striped"
            >
              <thead>
                <tr>
                  <th>预约日期</th>
                  <th>患者名字</th>
                  <th>预约科室</th>
                  <th>预约状态</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(order, index) in paginatedOrders" :key="index">
                  <td>{{ formattedDate(order.appointmentDate) }}</td>
                  <td>{{ order.patientName }}</td>
                  <td>{{ order.appointmentDepartment }}</td>
                  <td>
                    <el-popover
                      trigger="click"
                      placement="top-start"
                      width="200"
                    >
                      <template slot="reference">
                        <el-button
                          :type="
                            order.appointmentStatus === '未通过'
                              ? 'danger'
                              : 'success'
                          "
                        >
                          {{ order.appointmentStatus }}
                        </el-button>
                      </template>
                      <div>
                        <p>确认更改预约状态为：</p>
                        <el-button
                          type="success"
                          size="mini"
                          @click="confirmStatus(order, '通过')"
                          >通过</el-button
                        >
                        <el-button
                          type="danger"
                          size="mini"
                          @click="confirmStatus(order, '未通过')"
                          >未通过</el-button
                        >
                      </div>
                    </el-popover>
                  </td>
                </tr>
              </tbody>
            </table>
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
export default {
  components: {},
  data() {
    return {
      orders: [
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
      ],
      perPage: 10,
      currentPage: 1,
      searchQuery: "",
    };
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
    formattedDate() {
      return (dateString) => {
        const date = new Date(dateString);
        return `${date.getFullYear()}-${(date.getMonth() + 1)
          .toString()
          .padStart(2, "0")}-${date.getDate().toString().padStart(2, "0")}`;
      };
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
    setCurrentPage(page) {
      this.currentPage = page;
    },
    handleSearch() {
      this.currentPage = 1;
    },
    confirmStatus(order, status) {
      this.$confirm(`确认更改预约状态为${status}?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          order.appointmentStatus = status;
          this.$notify({
            title: "成功",
            message: "预约状态已更新",
            type: "success",
          });
        })
        .catch(() => {

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
.aa{
  max-height: 80%;
}
.aaa{
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
