$(document).ready(function(){
    $('#btn-next').click(function(_event){
        var slide_sau = $('.active').next();
        $('.active').addClass('bien-mat-ben-trai').one('webkiAnimationEng', function(event){
            $('.di-vao-ben-phai').removeClass('di-vao-ben-phai');
        });
        slide_sau.addClass('active').addClass('di-vao-ben-phai').one('webkitAnimationEnd', function(event){
            $('.di-vao-ben-phai').removeClass('di-vao-ben-phai');
        });
    });
});