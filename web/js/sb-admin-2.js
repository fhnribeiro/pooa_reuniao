(function($) {
  "use strict"; // Start of use strict

  // Toggle the side navigation
  $("#sidebarToggle, #sidebarToggleTop").on('click', function(e) {
    $("body").toggleClass("sidebar-toggled");
    $(".sidebar").toggleClass("toggled");
    if ($(".sidebar").hasClass("toggled")) {
      $('.sidebar .collapse').collapse('hide');
    };
  });

  // Close any open menu accordions when window is resized below 768px
  $(window).resize(function() {
    if ($(window).width() < 768) {
      $('.sidebar .collapse').collapse('hide');
    };
  });

  // Prevent the content wrapper from scrolling when the fixed side navigation hovered over
  $('body.fixed-nav .sidebar').on('mousewheel DOMMouseScroll wheel', function(e) {
    if ($(window).width() > 768) {
      var e0 = e.originalEvent,
        delta = e0.wheelDelta || -e0.detail;
      this.scrollTop += (delta < 0 ? 1 : -1) * 30;
      e.preventDefault();
    }
  });

  // Scroll to top button appear
  $(document).on('scroll', function() {
    var scrollDistance = $(this).scrollTop();
    if (scrollDistance > 100) {
      $('.scroll-to-top').fadeIn();
    } else {
      $('.scroll-to-top').fadeOut();
    }
  });

  // Smooth scrolling using jQuery easing
  $(document).on('click', 'a.scroll-to-top', function(e) {
    var $anchor = $(this);
    $('html, body').stop().animate({
      scrollTop: ($($anchor.attr('href')).offset().top)
    }, 1000, 'easeInOutExpo');
    e.preventDefault();
  });
  
  $("#addEquipment").click(function(){
    if( $("#listEquipamentSelected [value='"+$("#selectEquipamento option:selected").val()+"']").length==0){
        $("#listEquipamentSelected").append($("<li/>").html("<span>"+$('#selectEquipamento option:selected').text()+"</span><input type='hidden' name='equipment' value='"+$('#selectEquipamento option:selected').val()+"'/><input type='button' value='-' class='removeEquipment floatRight'/><div class='clear'></div>"));
    }
  });
  
   $("#addEmployee").click(function(){
    if( $("#listEmployeesSelected [value='"+$("#selectFuncionario option:selected").val()+"']").length==0){
        $("#listEmployeesSelected").append($("<li/>").html("<span>"+$('#selectFuncionario option:selected').text()+"</span><input type='hidden' name='employee' value='"+$('#selectFuncionario option:selected').val()+"'/><input type='button' value='-' class='removeEmployee floatRight'/><div class='clear'></div>"));
    }
  });
  
  $(document).on('click', '.removeEquipment,.removeEmployee', function(e) {
      $(this).parents("li").remove();
  });

})(jQuery); // End of use strict
