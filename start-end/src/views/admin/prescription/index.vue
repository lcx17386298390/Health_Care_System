<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="病例id" prop="diseaseId">
        <el-input
          v-model="queryParams.diseaseId"
          placeholder="请输入病例id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="病名" prop="diseaseName">
        <el-input
          v-model="queryParams.diseaseName"
          placeholder="请输入病名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="患病的简介" prop="diseaseDesc">
        <el-input
          v-model="queryParams.diseaseDesc"
          placeholder="请输入患病的简介"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开处方医生id" prop="did">
        <el-input
          v-model="queryParams.did"
          placeholder="请输入开处方医生id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="医生姓名" prop="dname">
        <el-input
          v-model="queryParams.dname"
          placeholder="请输入医生姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="患者id" prop="pid">
        <el-input
          v-model="queryParams.pid"
          placeholder="请输入患者id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="患者姓名" prop="pname">
        <el-input
          v-model="queryParams.pname"
          placeholder="请输入患者姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="药瓶信息" prop="drugs">
        <el-input
          v-model="queryParams.drugs"
          placeholder="请输入药瓶信息"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['prescription:prescription:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['prescription:prescription:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['prescription:prescription:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['prescription:prescription:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="prescriptionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="处方id" align="center" prop="id" />
      <el-table-column label="病例id" align="center" prop="diseaseId" />
      <el-table-column label="病名" align="center" prop="diseaseName" />
      <el-table-column label="患病的简介" align="center" prop="diseaseDesc" />
      <el-table-column label="开处方医生id" align="center" prop="did" />
      <el-table-column label="医生姓名" align="center" prop="dname" />
      <el-table-column label="患者id" align="center" prop="pid" />
      <el-table-column label="患者姓名" align="center" prop="pname" />
      <el-table-column label="药瓶信息" align="center" prop="drugs" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['prescription:prescription:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['prescription:prescription:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改医生处方对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="病例id" prop="diseaseId">
          <el-input v-model="form.diseaseId" placeholder="请输入病例id" />
        </el-form-item>
        <el-form-item label="病名" prop="diseaseName">
          <el-input v-model="form.diseaseName" placeholder="请输入病名" />
        </el-form-item>
        <el-form-item label="患病的简介" prop="diseaseDesc">
          <el-input v-model="form.diseaseDesc" placeholder="请输入患病的简介" />
        </el-form-item>
        <el-form-item label="开处方医生id" prop="did">
          <el-input v-model="form.did" placeholder="请输入开处方医生id" />
        </el-form-item>
        <el-form-item label="医生姓名" prop="dname">
          <el-input v-model="form.dname" placeholder="请输入医生姓名" />
        </el-form-item>
        <el-form-item label="患者id" prop="pid">
          <el-input v-model="form.pid" placeholder="请输入患者id" />
        </el-form-item>
        <el-form-item label="患者姓名" prop="pname">
          <el-input v-model="form.pname" placeholder="请输入患者姓名" />
        </el-form-item>
        <el-form-item label="药瓶信息" prop="drugs">
          <el-input v-model="form.drugs" placeholder="请输入药瓶信息" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listPrescription, getPrescription, delPrescription, addPrescription, updatePrescription } from "@/api/prescription/prescription";

export default {
  name: "Prescription",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 医生处方表格数据
      prescriptionList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        diseaseId: null,
        diseaseName: null,
        diseaseDesc: null,
        did: null,
        dname: null,
        pid: null,
        pname: null,
        drugs: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询医生处方列表 */
    getList() {
      this.loading = true;
      listPrescription(this.queryParams).then(response => {
        this.prescriptionList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        diseaseId: null,
        diseaseName: null,
        diseaseDesc: null,
        did: null,
        dname: null,
        pid: null,
        pname: null,
        drugs: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加医生处方";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPrescription(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改医生处方";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePrescription(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPrescription(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除医生处方编号为"' + ids + '"的数据项？').then(function() {
        return delPrescription(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('http://localhost:8002/prescription/prescription/export', {
        ...this.queryParams
      }, `prescription_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
