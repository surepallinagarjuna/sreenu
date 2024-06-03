(function($) {
    $(document).on("dialog-ready", function() {
        var dropdown = $("coral-select[name='./profession']");
        var checkbox = $("coral-checkbox[name='./student']");

        function toggleCheckbox() {
            if (dropdown.val() === "business" || dropdown.val() === "employ") {
                checkbox.prop("disabled", true);
            } else {
                checkbox.prop("disabled", false);
            }
        }

        // Initial toggle
        toggleCheckbox();

        // Listen for change in dropdown value
        dropdown.on("change", toggleCheckbox);
    });
})(Granite.$);