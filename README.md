Coffee and Bites – Mobile Application

Coffee and Bites is an Android-based mobile application developed using Kotlin and XML. This application allows users to explore menus, customize beverages and desserts, manage their shopping cart, and place orders through a simple and user-friendly interface.
The application is designed based on assignment wireframes and UI guidelines, featuring a warm coffee-inspired theme and an intuitive ordering experience.

 Features

 1. Splash & Welcome Screen
- Displays the Coffee and Bites branding.
- Provides an attractive introduction to the application.

 2. Authentication
- User Sign Up and Login pages.
- Input validation for user credentials.
- Password visibility toggle.
- User-friendly authentication interface.

 3. Home Menu & Categories
- Displays available food and beverage products.
- Dynamic menu filtering by category:
    - Coffee
    - Non-Coffee
    - Dessert
- Product information and menu selection.

 4. Product Customization
- Bottom Sheet interface for customizing selected products.
- Available customization options:
    - Quantity
    - Beverage Size
    - Milk Type
    - Sugar Level
    - Extra Shot (for eligible coffee products)
- Customization options adapt to the selected product category.

 5. Shopping Cart
- Floating Action Cart Button.
- Dynamic cart item counter.
- Add and manage selected products.
- View selected items before checkout.

 6. Order Flow

A multi-step ordering process consisting of:

- Shipping Address: Users enter recipient information and delivery address.
- Order Validation: Displays order details and validates the selected items.
- Order Confirmation: Shows successful order confirmation with a checkmark indicator.

 7. My Profile
- Displays user profile information.
- Provides an overview of profile settings.

 Tech Stack & Tools

- Programming Language: Kotlin
- UI Design: Android XML Layouts
- UI Components: Material Design Components
- Design System: Material 3
- IDE: Android Studio
- Minimum SDK: API 21 (Android 5.0 Lollipop)
- Target SDK: API 34 (Android 14)

 Project Structure


app/
└── src/
    └── main/
        ├── java/
        │   └── com/example/coffeeandbites/
        │       ├── SplashActivity.kt
        │       ├── SignUpActivity.kt
        │       ├── LoginActivity.kt
        │       ├── RegisterActivity.kt
        │       ├── HomeActivity.kt
        │       ├── ProfileActivity.kt
        │       ├── ShippingAddressActivity.kt
        │       ├── OrderValidationActivity.kt
        │       ├── OrderConfirmationActivity.kt
        │       ├── MenuAdapter.kt
        │       ├── MenuItem.kt
        │       ├── CartItem.kt
        │       └── CartManager.kt
        │
        └── res/
            ├── layout/
            │   ├── activity_splash.xml
            │   ├── activity_sign_up.xml
            │   ├── activity_login.xml
            │   ├── activity_register.xml
            │   ├── activity_home.xml
            │   ├── activity_profile.xml
            │   ├── activity_shipping_address.xml
            │   ├── activity_order_validation.xml
            │   ├── activity_order_confirmation.xml
            │   ├── dialog_customize_menu.xml
            │   └── item_menu.xml
            │
            └── drawable/


 UI Design Concept

The application uses a coffee-inspired visual concept with a warm and inviting color palette.

Design highlights:
- Coffee-themed color combinations.
- Clean and organized layouts.
- Rounded input fields and buttons.
- Consistent typography and spacing.
- User-friendly navigation.
- Responsive layouts using Android XML.

 Getting Started

Follow these steps to run the project:

1. Clone or download this repository.
2. Open the project using Android Studio.
3. Wait for Gradle Sync to finish.
4. Connect an Android device or start an emulator.
5. Build and run the application.

 Project Information

- Project Name: Coffee and Bites
- Platform: Android
- Development Language: Kotlin
- Layout: XML
- Development Environment: Android Studio
- Target Platform: Android 14

---

Coffee and Bites – Your Favorite Coffee and Treats, Just a Tap Away!
