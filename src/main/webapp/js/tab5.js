var datas = [{
  name: '张三',
  subject: 'JavaScript',
  score: 100
}, {
  name: '李四',
  subject: 'Python',
  score: 98
}, {
  name: '王五',
  subject: 'JavaScript',
  score: 99
}, {
  name: '赵六',
  subject: 'J2EE',
  score: 95
}];
// 2. 获取根节点，往tbody 里面创建行： 有几个人（通过数组的长度）就创建几行
var tab5 = document.getElementById('tab5')
  // 所有数据都是放在 tbody 中的 tr 里面
for (var i = 0; i < datas.length; i++) { // 外面的for循环管行 tr
  // 1. 创建 tr行
  var tr = document.createElement('tr');
  tab5.appendChild(tr);
  // 2. 行里面创建单元格(跟数据有关系的3个单元格) td 单元格的数量取决于每个对象里面的属性个数  for循环遍历对象 datas[i]
  for (var k in datas[i]) { // 里面的for循环管列 td
    // 创建单元格 
    var td = document.createElement('td');
    td.innerHTML = datas[i][k];
    tr.appendChild(td);
  }
  // 3. 创建有删除两个字的单元格 
  var td = document.createElement('td');
  td.innerHTML = '<a href="javascript:;"onclick="Mydelete_5(this)">删除</a>' +
    '<a href = "javascript:;"onclick = "MyUpdate_5(this)">修改</a>';
  tr.appendChild(td);
}
// 4. 删除操作
function Mydelete_5(btn) {
  let tr = btn.parentNode.parentNode;
  if (confirm("确认删除该条记录吗？")) {
    document.getElementById('tab5').removeChild(tr);
  }
}

function MyUpdate_5(btn) {
  let thistd = btn.parentNode;
  let idtd = thistd.previousSibling;
  let phonetd = idtd.previousSibling;
  let nametd = phonetd.previousSibling;

  nametd.innerHTML = "<input type='text' value='" + nametd.innerText + "'/>";
  phonetd.innerHTML = "<input type='text' value='" + phonetd.innerText + "'/>";
  idtd.innerHTML = "<input type='text' value='" + idtd.innerText + "'/>";
  thistd.innerHTML = "<a href='javascript:;'onclick='MySave_5(this)'>保存</a>";
}

function MySave_5(btn) {
  let thistd = btn.parentNode;
  let idtd = thistd.previousSibling;
  let phonetd = idtd.previousSibling;
  let nametd = phonetd.previousSibling;

  nametd.innerHTML = "" + nametd.getElementsByTagName('input')[0].value;
  phonetd.innerHTML = "" + phonetd.getElementsByTagName('input')[0].value;
  idtd.innerHTML = "" + idtd.getElementsByTagName('input')[0].value;
  thistd.innerHTML = '<a href="javascript:;"onclick="Mydelete_5(this)">删除</a>' +
    '<a href = "javascript:;"onclick = "MyUpdate_5(this)">修改</a>';
}