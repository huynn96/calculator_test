Feature: Calculate

  Scenario: Calculate with operator
    Given Open the web page calculator
    When Calculate numbers
      | number_1 | operator_1 | number_2 | operator_2 | number_3 | result       |
      | 1        | +          | 2        |            |          | 3            |
      | 1.2      | +          | 2.3      |            |          | 3.5          |
      | -1.2     | +          | 2.3      |            |          | 1.1          |
      | 1        | -          | 2        |            |          | -1           |
      | 2.3      | -          | 1.2      |            |          | 1.1          |
      | -2.3     | -          | 1.2      |            |          | -3.5         |
      | 1        | *          | 2        |            |          | 2            |
      | 2.3      | *          | 1.2      |            |          | 2.76         |
      | -2.3     | *          | 1.2      |            |          | -2.76        |
      | 1        | /          | 2        |            |          | 0.5          |
      | 2.3      | /          | 1.2      |            |          | 1.916666667  |
      | -2.3     | /          | 1.2      |            |          | -1.916666667 |
      | -2.3     | /          | 0        |            |          | undefined    |
      | -2.3     | /          | 1.2      | *          | 3.5      | -0.5476190476 |
    Then Check the result
