# Railway Customer Management System

A comprehensive Java Swing application for managing railway operations and customer data with a modern GUI interface.

## Features

### Customer Management
- ✅ Add new customers with complete details
- ✅ Update existing customer information
- ✅ Delete customers with confirmation
- ✅ View all customers in a sortable table
- ✅ Form validation and error handling
- ✅ Budget tracking with currency formatting

### Railway Management
- ✅ Add new train routes and schedules
- ✅ Update train information
- ✅ Delete train records
- ✅ Comprehensive station database (35+ major Indian cities)
- ✅ Time formatting for departure/arrival
- ✅ Source and destination selection

### Technical Features
- 🎨 Modern Swing GUI with Nimbus Look & Feel
- 🚂 Custom train icon and branding
- 📊 Interactive tables with selection handling
- 🔄 Complete CRUD operations for both modules
- ⚡ Real-time form updates
- 🎯 Input validation and error messages

## Screenshots

The application features a tabbed interface with:
- **Customer Management Tab**: Complete customer lifecycle management
- **Railway Management Tab**: Train schedule and route management

## Getting Started

### Prerequisites
- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans)

### Running the Application

1. Clone the repository:
```bash
git clone https://github.com/AtharvaLotankar11/Railway-and-Customer-Java-Project.git
```

2. Navigate to the project directory:
```bash
cd Railway-and-Customer-Java-Project
```

3. Compile and run:
```bash
javac src/RailwayManagementApp.java
java -cp src RailwayManagementApp
```

Or run directly from your IDE by executing the `main` method in `RailwayManagementApp.java`.

## Project Structure

```
Railway-and-Customer-Java-Project/
├── src/
│   └── RailwayManagementApp.java    # Main application file
├── out/                             # Compiled classes
├── README.md                        # Project documentation
└── .gitignore                       # Git ignore rules
```

## Usage

### Customer Management
1. Switch to the "👥 Customer Management" tab
2. Fill in customer details in the form
3. Click "Add Customer" to create new records
4. Select a row in the table to edit existing customers
5. Use "Update Customer" to save changes
6. Use "Delete Customer" to remove records (with confirmation)
7. "Clear Form" resets all input fields

### Railway Management
1. Switch to the "🚂 Railway Management" tab
2. Enter train details including name, route, and timings
3. Select source and destination from the dropdown (35+ stations)
4. Use time format HHMM (e.g., 1430 for 2:30 PM)
5. Perform CRUD operations similar to customer management

## Technical Details

- **Language**: Java
- **GUI Framework**: Swing
- **Design Pattern**: MVC-inspired architecture
- **Data Storage**: In-memory (ArrayList)
- **Look & Feel**: Nimbus (with fallback to system default)

## Sample Data

The application comes pre-loaded with sample data:
- 2 sample customers
- 2 sample train routes (Rajdhani Express, Shatabdi Express)

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Future Enhancements

- 💾 Database integration (MySQL/PostgreSQL)
- 🔐 User authentication and authorization
- 📱 Responsive design for different screen sizes
- 📊 Advanced reporting and analytics
- 🎫 Ticket booking integration
- 📧 Email notifications
- 🔍 Advanced search and filtering

## License

This project is open source and available under the [MIT License](LICENSE).

## Author

**Atharva Lotankar**
- GitHub: [@AtharvaLotankar11](https://github.com/AtharvaLotankar11)

## Acknowledgments

- Thanks to the Java Swing community for excellent documentation
- Inspired by real-world railway management systems
- Built as part of Java learning journey

---

⭐ If you found this project helpful, please give it a star!