new Vue({
            el: "#app_2",

            mounted() {
                //页面加载完成之后发送异步请求获取数据

                this.selectByPage();
                this.getTotal();
            },

            methods: {
                //查询分页数据
                selectByPage() {
                    var index = (this.currentPage - 1) * this.pageSize;
                    var _this = this;

                    axios({
                        method: "get",
                        url:"http://localhost/tasks/page?pageSize="+_this.pageSize+"&index="+index,
                        data: this.task
                    }).then(function (resp) {
                        //设置表格数据
                        //console.log(resp.data)
                        _this.tableData = resp.data;
                    })
                },

                getTotal(){
                    var _this = this;
                    axios({
                        method: "get",
                        url: "http://localhost/tasks",
                    }).then(function (resp) {
                        _this.totalCount = resp.data;
                    })
                },

                selectByName() {
                    var _this = this;
                    axios({
                        method: "post",
                        url: "http://localhost/tasks/name",
                        data:_this.task
                    }).then(function (resp) {
                        //console.log(resp.data);
                        //设置表格数据
                        _this.tableData = resp.data;
                        //设置总记录数
                        _this.totalCount = _this.tableData.length;
                    })
                },
                
                //复选框选中后回调函数
                handleSelectionChange(val) {
                    this.multipleSelection = val;
                },

                //条件查询方法
                onSubmit() {
                    //console.log(this.task);
                    this.selectByName();
                },

                //添加数据
                addTask() {
                    //console.log(this.task);
                    //发送ajax异步请求发送数据
                    var _this = this;
                    axios({
                        method: "post",
                        url: "http://localhost/tasks",
                        data: _this.task
                    }).then(function (resp) {
                            //添加成功
                            //关闭窗口
                            _this.dialogVisible_add = false;
                            //重新查询、重载页面
                            _this.selectByPage();

                            _this.$message({
                                message: '客户添加成功！',
                                type: 'success'
                            });
                    })
                },

                //添加维修任务
                addRepair() {
                    //发送ajax异步请求发送数据
                    var _this = this;
                    axios({
                        method: "post",
                        url: "http://localhost/repairs",
                        data: _this.form
                    }).then(function (resp) {
                            //添加成功
                            //关闭窗口
                            _this.dialogVisible_confirmation = false;
                            //重新查询、重载页面
                            _this.selectByPage();

                            _this.$message({
                                message: '客户添加成功！',
                                type: 'success'
                            });
                    })
                },
                //分页
                handleSizeChange(val) {
                    ////console.log(`每页 ${val} 条`);
                    //重新设置每页显示条数
                    this.pageSize = val;
                    this.selectByPage();
                },
                handleCurrentChange(val) {
                    ////console.log(`当前页: ${val}`);
                    //重新设置当前页
                    this.currentPage = val;
                    this.selectByPage();
                },

                //批量删除
                deleteByIds() {
                    //弹出确认框，防止误操作
                    this.$confirm('此操作将永久删除所选数据, 是否继续?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        //点击确认按钮，执行删除操作

                        //创建id数组,从复选框获取
                        for (let i = 0; i < this.multipleSelection.length; i++) {
                            let selectionElement = this.multipleSelection;
                            this.selectedIds[i] = selectionElement.id;
                        }

                        var _this = this;
                        //发送ajax请求
                        axios({
                            method: "post",
                            url: "",
                            data: _this.selectedIds
                        }).then(function (resp) {
                                //删除成功
                                //重新查询、重载页面
                                _this.selectByPage();

                                _this.$message({
                                    message: '删除成功！',
                                    type: 'success'
                                });
                        })
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消删除'
                        });
                    });
                },

                //单项删除
                handleDelete(btn) {
                    //console.log(btn);
                    //弹出确认框，防止误操作
                    this.$confirm('此操作将永久删除该项数据, 是否继续?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        //点击确认按钮，执行删除操作

                        var _this = this;
                        //发送ajax请求
                        axios({
                            method: "delete",
                            url: "http://localhost/tasks/"+ btn,
                            data: btn
                        }).then(function (resp) {
                                //删除成功
                                //重新查询、重载页面
                                _this.selectByPage();

                                _this.$message({
                                    message: '删除成功！',
                                    type: 'success'
                                });
                        })
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消删除'
                        });
                    });

                },

                //弹出修改数据窗口
                handleUpdate(btn) {
                    axios({
                        method: "get",
                        url: "http://localhost/tasks/"+btn,
                        data: btn
                    }).then(resp => {
                        this.form = resp.data;
                        this.dialogVisible_edit = true;
                    })
                },

                //弹出更改状态窗口
                handleState(btn) {
                    axios({
                        method: "get",
                        url: "http://localhost/tasks/"+btn,
                        data: btn
                    }).then(resp => {
                        this.form = resp.data;
                        this.dialogVisible_state = true;
                    })
                },

                //修改数据
                handleEdit() {
                    //发送ajax异步请求发送数据
                    var _this = this;
                    axios({
                        method: "put",
                        url: "http://localhost/tasks",
                        data: _this.form
                    }).then(function (resp) {
                            //添加成功,关闭窗口
                            _this.dialogVisible_edit = false;
                            //重新查询、重载页面
                            _this.selectByPage();

                            _this.$message({
                                message: '数据修改成功！',
                                type: 'success'
                            });
                    })
                },

                //修改状态
                handleStateEdit() {
                    //发送ajax异步请求发送数据
                    var _this = this;
                    axios({
                        method: "put",
                        url: "http://localhost/tasks",
                        data: _this.form
                    }).then(function (resp) {
                            //添加成功,关闭窗口
                            _this.dialogVisible_state = false;
                            //重新查询、重载页面
                            _this.selectByPage();

                            _this.$message({
                                message: '状态更改成功！',
                                type: 'success'
                            });
                    })
                },

                //客户确认单
                handleConfirmation(btn) {
                    axios({
                        method: "get",
                        url: "http://localhost/tasks/"+btn,
                        data: btn
                    }).then(resp => {
                        this.form = resp.data;
                        this.dialogVisible_confirmation = true;
                    })
                }
            },

            data() {
                return {
                    //是否禁用选择框
                    isDisabled: false,

                    //每页显示的条数
                    pageSize: 5,
                    //总记录数
                    totalCount: 100,
                    //当前页码
                    currentPage: 1,

                    //添加表单数据
                    form: {
                        clientname: "王小虎",
                        description: "哈哈哈哈哈哈",
                        state: "待处理",
                        id: "111",
                        repairname:""
                    },

                    //对话框是否显示参数
                    dialogVisible_add: false,
                    dialogVisible_edit: false,
                    dialogVisible_confirmation: false,
                    dialogVisible_state: false,

                    //查询表单数据
                    task: {
                        clientname: "",
                        description: "",
                        state: "",
                        id: "",
                        repairname: ""
                    },

                    //表格数据
                    tableData: [],

                    //复选框选中数据
                    multipleSelection: [],

                    //被选中的数据的id
                    selectedIds: []
                }
            }
        })
 