# Date Class in Java

This Java program defines a `Date` class that provides various functionalities for handling dates, including validation, updating, comparison, and calculating differences. The program also contains a `Main` class that demonstrates the usage of the `Date` class.

## Features
- **Date Validation**: Ensures that a given date is valid.
- **Date Printing**: Displays the date in a readable format.
- **Date Comparison**: Implements the `Comparable` interface to allow sorting of dates.
- **Day of the Week Calculation**: Determines the day of the week for a given date.
- **Date Difference Calculation**: Computes the difference in days between two dates.
- **Date Updating**: Allows updating the date while ensuring validity.

---

## Class Overview

### `Date` Class
The `Date` class represents a date with `day`, `month`, and `year` attributes and provides methods for date manipulation and validation.

#### **Attributes:**
- `int date` - The day of the month.
- `int month` - The month number (1-12).
- `int year` - The year value.

#### **Methods:**
1. **`Date(int date, int month, int year)`**
   - Constructor to initialize a date.

2. **`boolean isValidDate(int date, int month, int year)`**
   - Validates whether the given date is correct considering leap years and month lengths.
   - Returns `true` if the date is valid, otherwise `false`.

3. **`void updateDate(int d, int m, int y)`**
   - Updates the date if the new values are valid.
   - Prints a confirmation message if updated successfully.

4. **`void printDate()`**
   - Prints the date in the format: `Month Day, Year`.
   - Example output: `March 25, 2025`.

5. **`int compareTo(Date date)`**
   - Compares the current date with another `Date` object.
   - Returns a negative value if the current date is earlier, zero if they are equal, and a positive value if the current date is later.

6. **`String getDayOfWeek()`**
   - Returns the day of the week for the given date.

7. **`String calculateDifference(Date subtrahend)`**
   - Calculates the absolute difference in days between two dates.
   - Returns a string in the format: `Difference is : X`.

---

## `Main` Class
The `Main` class demonstrates the functionality of the `Date` class.

### **Functionality Tested:**
- Creating `Date` objects.
- Checking date validity.
- Sorting a list of dates.
- Updating dates.
- Getting the day of the week.
- Calculating the difference between two dates.

### **Example Usage:**
```java
ArrayList<Date> dates = new ArrayList<>();
dates.add(new Date(25, 3, 2025));
dates.add(new Date(14, 5, 2020));

dates.get(0).printDate(); // Prints "March 25, 2025"
System.out.println(dates.get(0).getDayOfWeek()); // Prints the weekday
```

---

## Notes
- The program correctly handles leap years.
- Invalid dates (e.g., `32nd December` or negative years) are rejected.
- The `compareTo` method allows sorting dates in chronological order.

This project serves as a good introduction to working with dates in Java, including validation, sorting, and manipulation.
