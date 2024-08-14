document.addEventListener("DOMContentLoaded", function() {
    var dialog = document.querySelector(".cq-dialog");
    if (dialog) {
        dialog.addEventListener("click", function(event) {
            var target = event.target;
            if (target && target.classList.contains("coral-Multifield-add")) {
                var maxItems = 5; // Set the maximum number of items
                
                // Get the multifield container
                var multifield = target.closest(".coral-Multifield");
                
                // Check the number of items in the multifield
                var numOfItems = multifield.querySelectorAll(".coral-Multifield-item").length;
                
                // If the number of items exceeds the maximum limit, prevent adding more items
                if (numOfItems >= maxItems) {
                    alert("You cannot add more than " + maxItems + " items.");
                    event.preventDefault(); // Prevent default action (adding more items)
                }
            }
        });
    }
});
