Feature: Adding products to the cart

	@test1
	Scenario: Verify Add to cart option is enabled
		Given I search on Amazon with "Testing Automation"
		When I select search number 1  
		Then Verify Add to cart option is enabled
		
	@test2
	Scenario: Verify Item added to cart successfully
		Given I search on Amazon with "Testing Automation"
		When I select search number 1
		And I Add item to cart
		Then Verify Item added to cart successfully