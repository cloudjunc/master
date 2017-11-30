$(document).ready(function(){
    var title = window.location.search.slice(window.location.search.lastIndexOf("?")+1);
    $("#h1Title").html(title);
});
