(function($) {
    $(document).on("dialog-ready", function() {
        var dropdown = $("coral-select[name='./dropdown']");
        var checkbox = $("coral-checkbox[name='./checkbox']");

        function toggleCheckbox() {
            if (dropdown.val() === "Telangana" || dropdown.val() === "Karnataka") {
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