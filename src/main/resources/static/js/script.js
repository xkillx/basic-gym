var jumboHeight = $('.jumbotron').outerHeight();

function parallax() {
    var scrolled = $(window).scrollTop();
    $('.bg').css('height', (jumboHeight-scrolled) + 'px');
}

$(window).scroll(function(e){
    parallax();
});

$(document).ready(function() {
    var images = ['01.jpg', '02.jpg', '03.jpg', '04.jpg', '05.jpg'];
    $('.bg').css({'background-image': 'url(img/' + images[Math.floor(Math.random() * images.length)] + ')'});
});