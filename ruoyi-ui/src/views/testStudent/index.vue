<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学生名称" prop="studentName">
        <el-input
          v-model="queryParams.studentName"
          placeholder="请输入学生名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年龄" prop="studentAge">
        <el-input
          v-model="queryParams.studentAge"
          placeholder="请输入年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="爱好" prop="studentHobby">
        <el-input
          v-model="queryParams.studentHobby"
          placeholder="请输入爱好"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="studentSex">
        <el-select v-model="queryParams.studentSex" placeholder="请选择性别" clearable>
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="状态" prop="studentStatus">
        <el-select v-model="queryParams.studentStatus" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.sys_normal_disable"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="生日" prop="studentBirthday">
        <el-date-picker clearable
          v-model="queryParams.studentBirthday"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择生日">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker
          v-model="daterangeCreateTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
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
          v-hasPermi="['test:testStudent:save']"
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
          v-hasPermi="['test:testStudent:update']"
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
          v-hasPermi="['test:testStudent:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['test:testStudent:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="testStudentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" v-if="columns[0].visible" />
      <el-table-column label="学生名称" align="center" prop="studentName" v-if="columns[1].visible" />
      <el-table-column label="年龄" align="center" prop="studentAge" v-if="columns[2].visible" />
      <el-table-column label="爱好" align="center" prop="studentHobby" v-if="columns[3].visible" />
      <el-table-column label="性别" align="center" prop="studentSex" v-if="columns[4].visible" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.studentSex"/>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="studentStatus" v-if="columns[5].visible" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.studentStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="生日" align="center" prop="studentBirthday" width="180" v-if="columns[6].visible" >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.studentBirthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createTime" width="180" v-if="columns[7].visible" >
          <template slot-scope="scope">
              <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d} {h}:{m}:{s}') }}</span>
          </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['test:testStudent:update']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['test:testStudent:remove']"
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

    <!-- 添加或修改学生信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学生名称" prop="studentName">
          <el-input v-model="form.studentName" placeholder="请输入学生名称" />
        </el-form-item>
        <el-form-item label="年龄" prop="studentAge">
          <el-input-number v-model="form.studentAge" controls-position="right"></el-input-number>
        </el-form-item>
        <el-form-item label="爱好" prop="studentHobby">
          <el-input v-model="form.studentHobby" placeholder="请输入爱好" />
        </el-form-item>
        <el-form-item label="性别" prop="studentSex">
          <el-select v-model="form.studentSex" placeholder="请选择性别">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="状态" prop="studentStatus">
          <el-radio-group v-model="form.studentStatus">
            <el-radio
              v-for="dict in dict.type.sys_normal_disable"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="生日" prop="studentBirthday">
          <el-date-picker clearable
            v-model="form.studentBirthday"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择生日">
          </el-date-picker>
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
import { listTestStudent, getTestStudent, delTestStudent, addTestStudent, updateTestStudent } from "@/api/test/testStudent";

export default {
  name: "TestStudent",
  dicts: ['sys_user_sex', 'sys_normal_disable'],
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
      // 学生信息表格数据
      testStudentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 生日时间范围
      daterangeCreateTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        studentName: null,
        studentAge: null,
        studentHobby: null,
        studentSex: null,
        studentStatus: null,
        studentBirthday: null,
        createTime: null,
      },
      // 列信息
      columns: [
        { key: 0, label: `编号`, visible: true },
        { key: 1, label: `学生名称`, visible: true },
        { key: 2, label: `年龄`, visible: true },
        { key: 3, label: `爱好`, visible: true },
        { key: 4, label: `性别`, visible: true },
        { key: 5, label: `状态`, visible: true },
        { key: 6, label: `生日`, visible: true },
        { key: 7, label: `创建时间`, visible: true }
      ],
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        studentName: [
          { required: true, message: "学生名称不能为空", trigger: "blur" }
        ],
        studentStatus: [
          { required: true, message: "状态不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询学生信息列表 */
    getList() {
      this.loading = true;
      if (null != this.daterangeCreateTime && '' != this.daterangeCreateTime) {
        this.queryParams["beginCreateTime"] = this.daterangeCreateTime[0];
        this.queryParams["endCreateTime"] = this.daterangeCreateTime[1];
      }
      else {
        this.queryParams["beginCreateTime"] = null;
        this.queryParams["endCreateTime"] = null;
      }
      listTestStudent(this.queryParams).then(response => {
        this.testStudentList = response.data.records;
        this.total = response.data.total;
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
        studentName: null,
        studentAge: null,
        studentHobby: null,
        studentSex: null,
        studentStatus: null,
        studentBirthday: null,
        createTime: null,
        updateTime: null,
        deleteTime: null,
        createBy: null,
        updateBy: null
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
      this.daterangeCreateTime = [];
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
      this.title = "添加学生信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTestStudent(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学生信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTestStudent(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTestStudent(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除学生信息编号为"' + ids + '"的数据项？').then(function() {
        return delTestStudent(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('test/testStudent/export', {
        ...this.queryParams
      }, `testStudent_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
