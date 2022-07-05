new Vue({
            el: "#app_4",

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
                        url: "http://localhost/settles/page?pageSize="+_this.pageSize+"&index="+index,
                        //data:this.settle
                    }).then(function (resp) {
                        //设置表格数据
                        _this.tableData = resp.data;
                    })
                },

                getTotal(){
                    var _this = this;
                    axios({
                        method: "get",
                        url: "http://localhost/settles",
                    }).then(function (resp) {
                        _this.totalCount = resp.data;
                    })
                },

                selectByName() {
                    var _this = this;
                    axios({
                        method: "post",
                        url: "http://localhost/settles/name",
                        data:_this.settle
                    }).then(function (resp) {
                        //设置表格数据
                        _this.tableData = resp.data;
                        //设置总记录数
                        _this.totalCount = _this.tableData.length;
                    })
                },

                //条件查询方法
                onSubmit() {
                    console.log(this.settle);
                    this.selectByName();
                },

                //添加数据
                addSettle() {
                    //发送ajax异步请求发送数据
                    var _this = this;
                    axios({
                        method: "post",
                        url: "http://localhost/settles",
                        data: _this.settle
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

                //分页
                handleSizeChange(val) {
                    //console.log(`每页 ${val} 条`);
                    //重新设置每页显示条数
                    this.pageSize = val;
                    this.selectByPage();
                },
                handleCurrentChange(val) {
                    //console.log(`当前页: ${val}`);
                    //重新设置当前页
                    this.currentPage = val;
                    this.selectByPage();
                },
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
                        clientname: '',
                        repairname: '',
                        description: '',
                        money: '',
                        id: ''
                    },

                    //对话框是否显示参数
                    dialogVisible_add: false,

                    //查询表单数据
                    settle: {
                        clientname: '',
                        repairname: '',
                        description: '',
                        money: '',
                        id: ''
                    },

                    //表格数据
                    tableData: [],
                }
            }
        })
 