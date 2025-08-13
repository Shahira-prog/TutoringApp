package com.shahira.myuacademy.repositories

import com.shahira.myuacademy.R
import com.shahira.myuacademy.screens.crashcourses.Course

object CourseRepository {
    val allCourses = listOf(
        Course(
            title = "SAT Math Prep",
            icon= R.drawable.satmath,
            price = "$499.99",
            description = "The Official Digital SAT Study Guide™ provides a comprehensive resource for understanding updates to the SAT® in the digital format. It includes four official practice tests―all created by the test maker. As part of College Board’s commitment to access, practice tests are also available in the digital testing platform, Bluebook™, at no charge. However, the guide is the only place to find practice tests in print accompanied by over 300 pages of additional instruction, guidance, and test information.\n" +
                    "\n" +
                    "The Official Digital SAT Study Guide will help students get ready for the digital SAT with:\n" +
                    "• four official digital SAT practice tests, created from the same process used for the actual test.\n" +
                    "• detailed descriptions of the Reading and Writing and Math sections of the digital SAT.\n" +
                    "• targeted sample questions for each question type.\n" +
                    "• question drills by topic.\n" +
                    "• test-taking approaches and suggestions.\n" +
                    "• detailed explanations of right and wrong answers.\n" +
                    "• information on preparing for the digital PSAT/NMSQT® or PSAT™ 10.",
            details = { println("Opening Android Development details...") },
            "Enrolling",
            "28 hours",
            "MyU Academy and Zoom",
            "SatSun 10am-11am",
            "Sep 20-Dec 21"
        ),
        Course(
            title = "SAT English Prep",
            icon =  R.drawable.satmath,
            price = "$499.99",
            description = "The Official Digital SAT Study Guide™ provides a comprehensive resource for understanding updates to the SAT® in the digital format. It includes four official practice tests―all created by the test maker. As part of College Board’s commitment to access, practice tests are also available in the digital testing platform, Bluebook™, at no charge. However, the guide is the only place to find practice tests in print accompanied by over 300 pages of additional instruction, guidance, and test information.\n" +
                    "\n" +
                    "The Official Digital SAT Study Guide will help students get ready for the digital SAT with:\n" +
                    "• four official digital SAT practice tests, created from the same process used for the actual test.\n" +
                    "• detailed descriptions of the Reading and Writing and Math sections of the digital SAT.\n" +
                    "• targeted sample questions for each question type.\n" +
                    "• question drills by topic.\n" +
                    "• test-taking approaches and suggestions.\n" +
                    "• detailed explanations of right and wrong answers.\n" +
                    "• information on preparing for the digital PSAT/NMSQT® or PSAT™ 10.",
            details = { println("Opening Kotlin course details...") },
            "Enrolling",
            "28 hours",
            "MyU Academy and Zoom",
            "SatSun 11am-12pm",
            "Sep 20-Dec 21"
        ),
        Course(
            title = "AMC 8-10 Prep",
            icon = R.drawable.amc8_10,// Icons.Filled.School,
            price = "$499.99",
            description = "Middle School and Junior High Mathematics Challenge- GRADE 7-10\n" +
                    "The AMC 10 is a 25-question, 75-minute, multiple-choice examinations in high school mathematics designed to promote the development and enhancement of problem-solving skills.\n" +
                    "\n" +
                    "The AMC 10 is for students in 10th grade and below and covers the high school curriculum up to 10th grade. Students in grade 10 or below and under 17.5 years of age on the day of the contest can take the AMC 10.\n" +
                    "The AMC 10/12 is the first in a series of competitions that eventually lead all the way to the International Mathematical Olympiad (Source: Mathematical Association of America).\n" +
                    "\n" +
                    "This book is a great resource for students who take some well-known middle and junior high school mathematics contests such as American Mathematics Competitions (AMC-8/10), MathCON Finals, MATHCOUNTS®, and Math Leagues. It contains 10 practice tests and their full detailed solutions. The author, Dr. Sinan Kanbir, has extensive experience in math contest preparation and teaching mathematically promising students. Dr. Kanbir is the author and co-author of four research and teaching books and several publications about teaching and learning mathematics. He is an item writer for Central Wisconsin Math League (CWML), MathCON, and the Wisconsin section of the MAA math contest.",
            details = { println("Opening Jetpack Compose course details...") },
            "Enrolling",
            "28 hours",
            "MyU Academy and Zoom",
            "SatSun 12pm-1pm",
            "Sep 20-Dec 21"
        ),
        Course(
            title = "Mastering Kotlin for Android 14",
            icon = R.drawable.android14kotlin,// Icons.Filled.School,
            price = "$999.99",
            description = "Written with the best practices, this book will help you master Kotlin and use its powerful language features, libraries, tools, and APIs to elevate your Android apps.\n" +
                    "\n" +
                    "As you progress, you'll use Jetpack Compose and Material Design 3 to build UIs for your app, explore how to architect and improve your app architecture, and use Jetpack Libraries like Room and DataStore to persist your data locally. Using a step-by-step approach, this book will teach you how to debug issues in your app, detect leaks, inspect network calls fired by your app, and inspect your Room database. You'll also add tests to your apps to detect and address code smells.\n" +
                    "\n" +
                    "Toward the end, you’ll learn how to publish apps to the Google Play Store and see how to automate the process of deploying consecutive releases using GitHub actions, as well as learn how to distribute test builds to Firebase App Distribution. Additionally, the book covers tips on how to increase user engagement.\n" +
                    "\n" +
                    "By the end of this Kotlin book, you’ll be able to develop market-ready apps, add tests to their codebase, address issues, and get them in front of the right audience.\n" +
                    "\n" +
                    "What you will learn\n\n" +
                    "Build beautiful, responsive, and accessible UIs with Jetpack Compose\n" +
                    "Explore various app architectures and find out how you can improve them\n" +
                    "Perform code analysis and add unit and instrumentation tests to your apps\n" +
                    "Publish, monitor, and improve your apps in the Google Play Store\n" +
                    "Perform long-running operations with WorkManager and persist data in your app\n" +
                    "Use CI/CD with GitHub Actions and distribute test builds with Firebase App Distribution\n" +
                    "Find out how to add linting and static checks on CI/CD pipelines\n" +
                    "\nWho this book is for\n\n" +
                    "If you’re an aspiring Android developer or an Android developer working with Java, then this book is for you. Basic Java programming skills are a must if you want to fully utilize the techniques and best practices showcased in this book.\n" +
                    "\n" +
                    "Table of Contents\n\n" +
                    "Get Started with Kotlin Android Development\n" +
                    "Creating Your First Android App\n" +
                    "Jetpack Compose Layout Basics\n" +
                    "Design with Material Design 3\n" +
                    "Architect Your app\n" +
                    "Network Calls with Kotlin Coroutines\n" +
                    "Navigating within Your App\n" +
                    "Persisting Data Locally and Doing Background Work\n" +
                    "Runtime Permissions\n" +
                    "Debugging Your App\n" +
                    "Enhancing Code Quality\n" +
                    "Testing Your App\n" +
                    "Publishing Your App\n" +
                    "Continuous Integration and Continuous Deployment\n" +
                    "Improving Your App",
            details = { println("Opening Jetpack Compose course details...") },
            "Enrolling",
            "56 hours",
            "MyU Academy and Zoom",
            "SatSun 1pm-3pm",
            "Sep 20-Dec 21"
        ),
        Course(
            title = "Java: The Complete Reference",
            icon = R.drawable.javaprog,// Icons.Filled.School,
            price = "$1199.99",
            description = "Fully updated for Java SE 11, Java: The Complete Reference, Eleventh Edition explains how to develop, compile, debug, and run Java programs. Best-selling programming author Herb Schildt covers the entire Java language, including its syntax, keywords, and fundamental programming principles. You’ll also find information on key portions of the Java API library, such as I/O, the Collections Framework, the stream library, and the concurrency utilities. Swing, JavaBeans, and servlets are examined and numerous examples demonstrate Java in action. Of course, the very important module system is discussed in detail. This Oracle Press resource also offers an introduction to JShell, Java’s interactive programming tool. Best of all, the book is written in the clear, crisp, uncompromising style that has made Schildt the choice of millions worldwide.\n" +
                    "\n" +
                    "Coverage includes:\n" +
                    "\n" +
                    "•Data types, variables, arrays, and operators\n" +
                    "•Control statements\n" +
                    "•Classes, objects, and methods\n" +
                    "•Method overloading and overriding\n" +
                    "•Inheritance\n" +
                    "•Local variable type inference\n" +
                    "•Interfaces and packages\n" +
                    "•Exception handling\n" +
                    "•Multithreaded programming\n" +
                    "•Enumerations, autoboxing, and annotations\n" +
                    "•The I/O classes\n" +
                    "•Generics\n" +
                    "•Lambda expressions\n" +
                    "•Modules\n" +
                    "•String handling\n" +
                    "•The Collections Framework\n" +
                    "•Networking\n" +
                    "•Event handling\n" +
                    "•AWT\n" +
                    "•Swing\n" +
                    "•The Concurrent API\n" +
                    "•The Stream API\n" +
                    "•Regular expressions\n" +
                    "•JavaBeans\n" +
                    "•Servlets\n" +
                    "•Much, much more\n" +
                    "\n" +
                    "Code examples in the book are available for download at www.OraclePressBooks.com.",
            details = { println("Opening Jetpack Compose course details...") },
            "Enrolling",
            "56 hours",
            "MyU Academy and Zoom",
            "SatSun 5m-7pm",
            "Sep 20-Dec 21"
        ),
        Course(
            title = "Advanced Calculus",
            icon = R.drawable.advancedcalc,// Icons.Filled.School,
            price = "$999.99",
            description = "Tough Test Questions? Missed Lectures? Not Enough Time?\n" +
                    "\n" +
                    "Fortunately for you, there's Schaum's.\n" +
                    "\n" +
                    "More than 40 million students have trusted Schaum's to help them succeed in the classroom and on exams. Schaum's is the key to faster learning and higher grades in every subject. Each Outline presents all the essential course information in an easy-to-follow, topic-by-topic format. You also get hundreds of examples, solvedproblems, and practice exercises to test your skills.\n" +
                    "\n" +
                    "This Schaum's Outline gives you\n" +
                    "\n" +
                    "1,370 fully solved problems\n" +
                    "Complete review of all course fundamentals\n" +
                    "Clear, concise explanations of all Advanced Calculus concepts\n" +
                    "Fully compatible with your classroom text, Schaum's highlights all the important facts you need to know. Use Schaum's to shorten your study time--and get your best test scores!\n" +
                    "\n" +
                    "Topics include: Numbers; Sequences; Functions, Limits, and Continuity; Derivatives; Integrals; Partial Derivatives; Vectors; Applications of Partial Derivatives; Multiple Integrals; Line Integrals, Surface Integrals, and Integral Theorems; Infinite Series; Improper Integrals; Fourier Series; Fourier Integrals; Gamma and Beta Functions; and Functions of a Complex Variable\n" +
                    "\n" +
                    "Schaum's Outlines--Problem Solved.",
            details = { println("Opening Jetpack Compose course details...") },
            "Enrolling",
            "42 hours",
            "MyU Academy and Zoom",
            "SatSun 3pm-4:30pm",
            "Sep 20-Dec 21"
        ),

        Course(
            title = "Calculus: Multivariable",
            icon = R.drawable.multivariablecalc,// Icons.Filled.School,
            price = "$999.99",
            description = "Calculus: Multivariable, 12th Edition\n" +
                    "by Howard Anton (Author), Irl C. Bivens (Author), Stephen Davis (Author)\n" +
                    "\n" +
                    "In Calculus: Multivariable, 12th Edition, an expert team of mathematicians delivers a rigorous and intuitive exploration of calculus, introducing concepts like derivatives and integrals of multivariable functions. Using the Rule of Four, the authors present mathematical concepts from verbal, algebraic, visual, and numerical points of view. The book includes numerous exercises, applications, and examples that help readers learn and retain the concepts discussed within.\n" +
                    "\n" +
                    "11 THREE-DIMENSIONAL SPACE; VECTORS 767\n" +
                    "11.1 Rectangular Coordinates in 3-Space; Spheres; Cylindrical Surfaces 767\n" +
                    "11.2 Vectors 773\n" +
                    "11.3 Dot Product; Projections 785\n" +
                    "11.4 Cross Product 795\n" +
                    "11.5 Parametric Equations of Lines 805\n" +
                    "11.6 Planes in 3-Space 813\n" +
                    "11.7 Quadric Surfaces 821\n" +
                    "11.8 Cylindrical and Spherical Coordinates 832\n" +
                    "\n" +
                    "12 VECTOR-VALUED FUNCTIONS 841\n" +
                    "12.1 Introduction to Vector-Valued Functions 841\n" +
                    "12.2 Calculus of Vector-Valued Functions 848\n" +
                    "12.3 Change of Parameter; Arc Length 858\n" +
                    "12.4 Unit Tangent, Normal, and Binormal Vectors 868\n" +
                    "12.5 Curvature 873\n" +
                    "12.6 Motion Along a Curve 882\n" +
                    "12.7 Kepler’s Laws of Planetary Motion 895\n" +
                    "\n" +
                    "13 PARTIAL DERIVATIVES 906\n" +
                    "13.1 Functions of Two or More Variables 906\n" +
                    "13.2 Limits and Continuity 917\n" +
                    "13.3 Partial Derivatives 927\n" +
                    "13.4 Differentiability, Differentials, and Local Linearity 940\n" +
                    "13.5 The Chain Rule 949\n" +
                    "13.6 Directional Derivatives and Gradients 960\n" +
                    "13.7 Tangent Planes and Normal Vectors 971\n" +
                    "13.8 Maxima and Minima of Functions of Two Variables 977\n" +
                    "13.9 Lagrange Multipliers 989\n" +
                    "\n" +
                    "14 MULTIPLE INTEGRALS 1000\n" +
                    "14.1 Double Integrals 1000\n" +
                    "14.2 Double Integrals over Nonrectangular Regions 1009\n" +
                    "14.3 Double Integrals in Polar Coordinates 1018\n" +
                    "14.4 Surface Area; Parametric Surfaces 1026\n" +
                    "14.5 Triple Integrals 1039\n" +
                    "14.6 Triple Integrals in Cylindrical and Spherical Coordinates 1048\n" +
                    "14.7 Change of Variables in Multiple Integrals; Jacobians 1058\n" +
                    "14.8 Centers of Gravity Using Multiple Integrals 1071\n" +
                    "\n" +
                    "15 TOPICS IN VECTOR CALCULUS 1084\n" +
                    "15.1 Vector Fields 1084\n" +
                    "15.2 Line Integrals 1094\n" +
                    "15.3 Independence of Path; Conservative Vector Fields 1111\n" +
                    "15.4 Green’s Theorem 1122\n" +
                    "15.5 Surface Integrals 1130\n" +
                    "15.6 Applications of Surface Integrals; Flux 1138\n" +
                    "15.7 The Divergence Theorem 1148\n" +
                    "15.8 Stokes’ Theorem 1158anton",
            details = { println("Opening Jetpack Compose course details...") },
            "Enrolling",
            "42 hours",
            "MyU Academy and Zoom",
            "SatSun 7pm-9pm",
            "Sep 20-Dec 21"
        )

    )
}