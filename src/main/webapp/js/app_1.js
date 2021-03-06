new Vue({
            el: "#app_1",

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
                        url: "http://localhost/clients/page?pageSize="+_this.pageSize+"&index="+index+"",
                    }).then(function (resp) {
                        //设置表格数据
                        _this.tableData = resp.data;
                    })
                },

                getTotal(){
                    var _this = this;
                    axios({
                        method: "get",
                        url: "http://localhost/clients",
                    }).then(function (resp) {
                        _this.totalCount = resp.data;
                    })
                },

                onclick(){
                    this.dialogVisible_add = true;

                    this.user.clientname="";
                    this.user.companyname="";
                    this.user.phonenumber="";
                    this.user.description="";
                },

                selectByName() {
                    var _this = this;
                    axios({
                        method: "post",
                        url: "http://localhost/clients/name",
                        data:_this.user
                    }).then(function (resp) {
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
                    this.selectByName();
                },

                //添加数据
                addUser() {
                    //发送ajax异步请求发送数据
                    var _this = this;
                    axios({
                        method: "post",
                        url: "http://localhost/clients",
                        data: _this.user
                    }).then(function (resp) {
                            //添加成功
                            //关闭窗口
                            _this.dialogVisible_add = false;
                            //重新查询、重载页面
                            _this.user.clientname="";
                            _this.user.companyname="";
                            _this.user.phonenumber="";
                            _this.user.description="";

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
                            url: "http://localhost/clients/"+btn,
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
                        url: "http://localhost/clients/"+btn,
                        data: btn
                    }).then(resp => {
                        this.form = resp.data;
                        this.dialogVisible_edit = true;
                    })
                },

                //修改数据
                handleEdit() {
                    //发送ajax异步请求发送数据
                    var _this = this;
                    axios({
                        method: "put",
                        url: "http://localhost/clients",
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
                }
            },

            data() {
                return {
                    //每页显示的条数
                    pageSize: 5,
                    //总记录数
                    totalCount: 100,
                    //当前页码
                    currentPage: 1,

                    //添加表单数据
                    form: {
                        companyname: '111',
                        clientname: '111',
                        phonenumber: '111',
                        id: "111",
                        description:''
                    },

                    //对话框是否显示参数
                    dialogVisible_add: false,
                    dialogVisible_edit: false,

                    //查询表单数据
                    user: {
                        companyname: '',
                        clientname: '',
                        phonenumber: '',
                        id: "",
                        description:''
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
