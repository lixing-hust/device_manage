new Vue({
            el: "#app_5",

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
                        url: "http://localhost/partss/page?pageSize="+_this.pageSize+"&index="+index+"",
                        //data: this.component
                    }).then(function (resp) {
                        //设置表格数据
                        _this.tableData = resp.data;
                    })
                },

                getTotal(){
                    var _this = this;
                    axios({
                        method: "get",
                        url: "http://localhost/partss",
                    }).then(function (resp) {
                        _this.totalCount = resp.data;
                    })
                },

                selectByName() {
                    var _this = this;
                    axios({
                        method: "post",
                        url: "http://localhost/partss/name",
                        data:_this.component
                    }).then(function (resp) {
                        //设置表格数据
                        _this.tableData = resp.data;
                        //设置总记录数
                        _this.totalCount = _this.tableData.length;
                    })
                },

                onclick(){
                    this.dialogVisible_add = true;

                    this.component.money="";
                    this.component.count="";
                    this.component.name="";
                },

                selectByCheck() {
                    var _this = this;
                    axios({
                        method: "get",
                        url: "http://localhost/partss/state"
                    }).then(function (resp) {
                        //设置表格数据
                        _this.tableData = resp.data;
                        //设置总记录数
                        _this.totalCount = _this.tableData.length;
                    })
                },

                //条件查询方法
                onSubmit() {
                    console.log(this.component);
                    this.selectByName();
                },

                //添加数据
                addComponent() {
                    //发送ajax异步请求发送数据
                    var _this = this;
                    axios({
                        method: "post",
                        url: "http://localhost/partss",
                        data: _this.component
                    }).then(function (resp) {

                            //添加成功
                            //关闭窗口
                            _this.dialogVisible_add = false;

                            _this.component.money="";
                            _this.component.count="";
                            _this.component.name="";

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

                //弹出入库数据窗口
                handleIn(btn) {
                    axios({
                        method: "get",
                        url: "http://localhost/partss/"+btn,
                        data: btn
                    }).then(resp => {
                        this.form = resp.data;
                        this.dialogVisible_in = true;
                    })
                },
                //弹出出库数据窗口
                handleOut(btn) {
                    axios({
                        method: "get",
                        url: "http://localhost/partss/"+btn,
                        data: btn
                    }).then(resp => {
                        this.form = resp.data;
                        this.dialogVisible_out = true;
                    })
                },

                //入库零件
                handleEditIn() {
                    //发送ajax异步请求发送数据
                    var _this = this;
                    axios({
                        method: "put",
                        url: "http://localhost/partss/in",
                        data: _this.form
                    }).then(function (resp) {

                            //添加成功,关闭窗口
                            _this.dialogVisible_in = false;
                            //重新查询、重载页面
                            _this.selectByPage();

                            _this.$message({
                                message: '数据修改成功！',
                                type: 'success'
                            });

                    })
                },
            
                //出库零件
                handleEditOut() {
                    //发送ajax异步请求发送数据
                    var _this = this;
                    axios({
                        method: "put",
                        url: "http://localhost/partss/out",
                        data: _this.form
                    }).then(function (resp) {

                            //添加成功,关闭窗口
                            _this.dialogVisible_out = false;
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
                        name: '',
                        count: '',
                        money: '',
                        id: ""
                    },

                    //对话框是否显示参数
                    dialogVisible_add: false,
                    dialogVisible_edit: false,
                    dialogVisible_out:false,
                    dialogVisible_in:false,
                    //查询表单数据
                    component: {
                        name: '',
                        count: '',
                        money: '',
                        id: ""
                    },

                    //表格数据
                    tableData: [],
                }
            }
        })
 