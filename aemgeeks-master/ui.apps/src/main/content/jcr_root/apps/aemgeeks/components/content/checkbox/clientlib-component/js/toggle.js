Granite.$(document).on("coral-dialog-ready", function() {
            var $secondCheckbox = $("[name='./checkbox1']");
            $secondCheckbox.prop("checked", false); // Uncheck the second checkbox by default
        });

        Granite.$(document).on("change", "[name='./checkbox']", function() {
            var $secondCheckbox = $("[name='./checkbox1']");
            if ($(this).prop("checked")) {
                $secondCheckbox.prop("disabled", false);
            } else {
                $secondCheckbox.prop("disabled", true);
                $secondCheckbox.prop("checked", false); // Uncheck second checkbox if first is unchecked
            }
        });