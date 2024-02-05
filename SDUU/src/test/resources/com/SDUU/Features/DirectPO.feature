Feature: Create Direct PO Record without GST

  Scenario: Create a new Direct PO record without GST
    Given User is on the Direct PO creation page
    When User selects "Supplier Branch" from the dropdown in Basic Information tab
    And User enters Billing Site, Indent Date, Common Delivery Date, Department, and Delivery Address
    And User selects a product and enters its quantity and price in the Item Details tab
    And User presses the "Calculate" button
    And User selects a "Discount Type" from the dropdown
    And User tries to select the GST option
    Then User should not be able to select the GST option
    And User clicks on the "Save" button
    Then User should see a success message confirming the creation of the Direct PO record without GST

