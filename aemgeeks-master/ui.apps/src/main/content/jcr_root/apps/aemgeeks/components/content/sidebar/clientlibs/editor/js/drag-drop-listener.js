document.addEventListener('cq:dragstart', function(event) {

    var componentName = event.detail.componentName;
    

    console.log('Component Dragged: ' + componentName);
    

    $.post('/bin/servlet/url', {componentName: componentName}, function(response) {

        console.log('Servlet Response:', response);
    }).fail(function() {

        console.error('Error sending AJAX request');
    });
});
