<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="提货日期" prop="pickUpDate">
        <el-date-picker clearable size="small"
          v-model="queryParams.pickUpDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择提货日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="商品名称" prop="itemName">
        <el-input
          v-model="queryParams.itemName"
          placeholder="请输入商品名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分拣员" prop="sorterName">
        <el-input
          v-model="queryParams.sorterName"
          placeholder="请输入分拣员"
          clearable
          size="small"
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
          v-hasPermi="['analysis:sorter:add']"
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
          v-hasPermi="['analysis:sorter:edit']"
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
          v-hasPermi="['analysis:sorter:remove']"
        >删除</el-button>
      </el-col>
       <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['analysis:sorter:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          :loading="exportLoading"
          @click="handleExport"
          v-hasPermi="['analysis:sorter:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="sorterList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="提货日期" align="center" prop="pickUpDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.pickUpDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="服务站名称" align="center" prop="serviceStationName" />
      <el-table-column label="门店ID" align="center" prop="storeId" />
      <el-table-column label="门店名称" align="center" prop="storeName" />
      <el-table-column label="商品类型" align="center" prop="itemType" />
      <el-table-column label="商品ID" align="center" prop="itemId" />
      <el-table-column label="商品名称" align="center" prop="itemName" />
      <el-table-column label="商品件数" align="center" prop="itemNumber" />
      <el-table-column label="商品单价(元)" align="center" prop="itemPrice" />
      <el-table-column label="售后退款件数" align="center" prop="afterRefundsNumber" />
      <el-table-column label="退款金额(不含券)" align="center" prop="afterRefundsPrice" />
      <el-table-column label="实际退款比例" align="center" prop="afterRefundsRatio" />
      <el-table-column label="售后原因" align="center" prop="afterSalesReasons" />
      <el-table-column label="售后类型" align="center" prop="afterSalesType" />
      <el-table-column label="售后申请时间" align="center" prop="afterSalesTime" />
      <el-table-column label="售后退款时间" align="center" prop="afterRefundsTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.afterRefundsTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否批量退款" align="center" prop="batchRefund" />
      <el-table-column label="退款发起方" align="center" prop="refundOriginator" />
      <el-table-column label="司机名称" align="center" prop="driverName" />
      <el-table-column label="司机手机号" align="center" prop="driverPhone" />
      <el-table-column label="送达时间" align="center" prop="deliveryTime" />
      <el-table-column label="交货失败原因" align="center" prop="deliveryFailureReason" />
      <el-table-column label="站长确认缺货件数" align="center" prop="stationmasterItemNumber" />
      <el-table-column label="运营确认缺货件数" align="center" prop="operateItmeNumber" />
      <el-table-column label="申诉状态" align="center" prop="appealStatus" />
      <el-table-column label="服务站分拣方式" align="center" prop="serviceStationSort" />
      <el-table-column label="团点号/路线名" align="center" prop="serviceRoute" />
      <el-table-column label="分拣员名称" align="center" prop="sorterName" />
      <el-table-column label="实际分拣件数" align="center" prop="sorterActualNumber" />
      <el-table-column label="分拣缺货件数" align="center" prop="sorterPiecesNumber" />
      <el-table-column label="分拣开始时间" align="center" prop="sorterStartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.sorterStartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="服务站上报少货数" align="center" prop="serviceStationLessNumber" />
      <el-table-column label="服务站上报破损数" align="center" prop="serviceStationPiecesNumber" />
      <el-table-column label="服务站上报多货数" align="center" prop="serviceStationManyNumber" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['analysis:sorter:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['analysis:sorter:remove']"
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

    <!-- 添加或修改分拣员售后报对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="服务站上报多货数" prop="id">
          <el-input v-model="form.id" placeholder="请输入服务站上报多货数" />
        </el-form-item>
        <el-form-item label="提货日期" prop="pickUpDate">
          <el-date-picker clearable size="small"
            v-model="form.pickUpDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择提货日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="服务站名称" prop="serviceStationName">
          <el-input v-model="form.serviceStationName" placeholder="请输入服务站名称" />
        </el-form-item>
        <el-form-item label="门店名称" prop="storeName">
          <el-input v-model="form.storeName" placeholder="请输入门店名称" />
        </el-form-item>
        <el-form-item label="商品类型" prop="itemType">
          <el-select v-model="form.itemType" placeholder="请选择商品类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="商品名称" prop="itemName">
          <el-input v-model="form.itemName" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="商品件数" prop="itemNumber">
          <el-input v-model="form.itemNumber" placeholder="请输入商品件数" />
        </el-form-item>
        <el-form-item label="商品单价(元)" prop="itemPrice">
          <el-input v-model="form.itemPrice" placeholder="请输入商品单价(元)" />
        </el-form-item>
        <el-form-item label="售后退款件数" prop="afterRefundsNumber">
          <el-input v-model="form.afterRefundsNumber" placeholder="请输入售后退款件数" />
        </el-form-item>
        <el-form-item label="退款金额(不含券)" prop="afterRefundsPrice">
          <el-input v-model="form.afterRefundsPrice" placeholder="请输入退款金额(不含券)" />
        </el-form-item>
        <el-form-item label="实际退款比例" prop="afterRefundsRatio">
          <el-input v-model="form.afterRefundsRatio" placeholder="请输入实际退款比例" />
        </el-form-item>
        <el-form-item label="售后原因" prop="afterSalesReasons">
          <el-input v-model="form.afterSalesReasons" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="售后类型" prop="afterSalesType">
          <el-select v-model="form.afterSalesType" placeholder="请选择售后类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="售后退款时间" prop="afterRefundsTime">
          <el-date-picker clearable size="small"
            v-model="form.afterRefundsTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择售后退款时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否批量退款" prop="batchRefund">
          <el-input v-model="form.batchRefund" placeholder="请输入是否批量退款" />
        </el-form-item>
        <el-form-item label="退款发起方" prop="refundOriginator">
          <el-input v-model="form.refundOriginator" placeholder="请输入退款发起方" />
        </el-form-item>
        <el-form-item label="司机名称" prop="driverName">
          <el-input v-model="form.driverName" placeholder="请输入司机名称" />
        </el-form-item>
        <el-form-item label="司机手机号" prop="driverPhone">
          <el-input v-model="form.driverPhone" placeholder="请输入司机手机号" />
        </el-form-item>
        <el-form-item label="送达时间" prop="deliveryTime">
          <el-input v-model="form.deliveryTime" placeholder="请输入送达时间" />
        </el-form-item>
        <el-form-item label="交货失败原因" prop="deliveryFailureReason">
          <el-input v-model="form.deliveryFailureReason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="站长确认缺货件数" prop="stationmasterItemNumber">
          <el-input v-model="form.stationmasterItemNumber" placeholder="请输入站长确认缺货件数" />
        </el-form-item>
        <el-form-item label="运营确认缺货件数" prop="operateItmeNumber">
          <el-input v-model="form.operateItmeNumber" placeholder="请输入运营确认缺货件数" />
        </el-form-item>
        <el-form-item label="申诉状态">
          <el-radio-group v-model="form.appealStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="服务站分拣方式" prop="serviceStationSort">
          <el-input v-model="form.serviceStationSort" placeholder="请输入服务站分拣方式" />
        </el-form-item>
        <el-form-item label="团点号/路线名" prop="serviceRoute">
          <el-input v-model="form.serviceRoute" placeholder="请输入团点号/路线名" />
        </el-form-item>
        <el-form-item label="分拣员名称" prop="sorterName">
          <el-input v-model="form.sorterName" placeholder="请输入分拣员名称" />
        </el-form-item>
        <el-form-item label="实际分拣件数" prop="sorterActualNumber">
          <el-input v-model="form.sorterActualNumber" placeholder="请输入实际分拣件数" />
        </el-form-item>
        <el-form-item label="分拣缺货件数" prop="sorterPiecesNumber">
          <el-input v-model="form.sorterPiecesNumber" placeholder="请输入分拣缺货件数" />
        </el-form-item>
        <el-form-item label="分拣开始时间" prop="sorterStartTime">
          <el-date-picker clearable size="small"
            v-model="form.sorterStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择分拣开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="服务站上报少货数" prop="serviceStationLessNumber">
          <el-input v-model="form.serviceStationLessNumber" placeholder="请输入服务站上报少货数" />
        </el-form-item>
        <el-form-item label="服务站上报破损数" prop="serviceStationPiecesNumber">
          <el-input v-model="form.serviceStationPiecesNumber" placeholder="请输入服务站上报破损数" />
        </el-form-item>
        <el-form-item label="服务站上报多货数" prop="serviceStationManyNumber">
          <el-input v-model="form.serviceStationManyNumber" placeholder="请输入服务站上报多货数" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 分拣员售后导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px" append-to-body>
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip text-center" slot="tip">
          <span>仅允许导入xls、xlsx格式文件。</span>
        </div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listSorter, getSorter, delSorter, addSorter, updateSorter, exportSorter } from "@/api/analysis/sorter";
import { getToken } from "@/utils/auth";

export default {
  name: "Sorter",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
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
      // 分拣员售后报表格数据
      sorterList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      upload: {
        // 是否显示弹出层（分拣员导入）
        open: false,
        // 弹出层标题（分拣员导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "analysis/sorter/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        pickUpDate: null,
        itemName: null,
        sorterName: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [
          { required: true, message: "服务站上报多货数不能为空", trigger: "blur" }
        ],
        pickUpDate: [
          { required: true, message: "提货日期不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询分拣员售后报列表 */
    getList() {
      this.loading = true;
      listSorter(this.queryParams).then(response => {
        this.sorterList = response.rows;
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
        pickUpDate: null,
        serviceStationName: null,
        storeId: null,
        storeName: null,
        itemType: null,
        itemId: null,
        itemName: null,
        itemNumber: null,
        itemPrice: null,
        afterRefundsNumber: null,
        afterRefundsPrice: null,
        afterRefundsRatio: null,
        afterSalesReasons: null,
        afterSalesType: null,
        afterSalesTime: null,
        afterRefundsTime: null,
        batchRefund: null,
        refundOriginator: null,
        driverName: null,
        driverPhone: null,
        deliveryTime: null,
        deliveryFailureReason: null,
        stationmasterItemNumber: null,
        operateItmeNumber: null,
        appealStatus: "0",
        serviceStationSort: null,
        serviceRoute: null,
        sorterName: null,
        sorterActualNumber: null,
        sorterPiecesNumber: null,
        sorterStartTime: null,
        serviceStationLessNumber: null,
        serviceStationPiecesNumber: null,
        serviceStationManyNumber: null
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
      this.ids = selection.map(item => item.storeId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加分拣员售后报";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const storeId = row.storeId || this.ids
      getSorter(storeId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改分拣员售后报";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.storeId != null) {
            updateSorter(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSorter(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const storeIds = row.storeId || this.ids;
      this.$confirm('是否确认删除分拣员售后报编号为"' + storeIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delSorter(storeIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有分拣员售后报数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportSorter(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "分拣员售后导入";
      this.upload.open = true;
    },
    // 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },
    // 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false;
      this.upload.isUploading = false;
      this.$refs.upload.clearFiles();
      this.$alert(response.msg, "导入结果", { dangerouslyUseHTMLString: true });
      this.getList();
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    }
  }
};
</script>
