$(document).ready(function(){
    showBlog();
});

function increaseBlog() {
    var namepara=$('#name').val();
    var contentpara=$('#content').val();
    $.ajax({
        url:'/MainIndex',
        type:'POST',
        data:{name:namepara,content:contentpara},
        success:function (result) {
            var x=eval("("+result+")");
            var str=BuildContentDiv(x);
            $("#contentShow").html(str);
        },
        error:function (xhr) {
            alert("错误提示： " + xhr.status + " " + xhr.statusText);
        }
    });

}

function showBlog() {
    $.ajax({
        url:'/MainIndex',
        type:'GET',
        success:function (result) {
            var x=eval("("+result+")");
            var str=BuildContentDiv(x);
            $("#contentShow").html(str);
        },
        error:function (xhr) {
            alert("错误提示： " + xhr.status + " " + xhr.statusText);
        }
    });

}

function BuildContentDiv(jobjArray){
    // var str="<div id='contentShow'>"
    var str="";
    jobjArray.forEach(function(value,index,array){
        str+="<div class='bbl'>"
        str+= "<a href=\"BlogContent.html?tt=cs\" target=\"_blank\" class='blogIndexStyle'>"+value.name+"</a>"
        // str+= "<p>"+value.content+"</p>"
        str+="</div>"
    })
    // str+="</div>"
    return str
}
