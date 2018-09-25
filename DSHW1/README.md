Author: Ashot Janibekyan
Date of creation: 10/09/2018
Last modified: 14/09/2018

To use this framework, you have access to the following methods. Some of them are abstract, so you have to define new classes, we you wish.
#API, classes:

Class name: Widget
    Public methods:
        abstract double calculatePrice()
        String getName()
        void setName(String name)
    Child classes: DooToros, Critter.

    Class name: DooToros
        Public methods:
            int getMinAge()
            void setMinAge(int minAge)
            double calculatePrice() @Overriden
            String getName()
            void setName(String name)
        Child classes: CatBus, FloofyLop

        Class name: CatBus
            Public methods:
                int howFar()
                String style()
                String sayHi()
                String sayBye()
                int getMinAge()
                void setMinAge(int minAge)
                double calculatePrice() @Overriden
                String getName()
                void setName(String name)
            Child classes: SootBall.

            Class name: SootBall
                Public methods:
                    String style()
                    double calculatePrice()

                    int howFar()
                    String sayHi()
                    String sayBye()

                    int getMinAge()
                    void setMinAge(int minAge)
                    double calculatePrice() @Overriden
                    String getName()
                    void setName(String name)
                Child classes: none.

        Class name: FloofyLop
            Public methods:
                int howFar()
                String style()
                double calculatePrice(int priceFactor)
                int getMinAge()
                void setMinAge(int minAge)
                double calculatePrice() @Overriden
                String getName()
                void setName(String name)
            Child classes: none


    Class name: Critter
        Public methods:
            double getManufacturingCost()
            double calculatePrice() @Overridden
            double calculateSalePrice()
            String getName()
            void setName(String name)
        Child classes: Sonic.

        Class name: Sonic
            Public methods:
                calculatePrice(double markUpValue)
                String sayHi()
                String sayBye()

                double getManufacturingCost()
                double calculatePrice() @Overridden
                double calculateSalePrice()
                String getName()
                void setName(String name)
            Child classes: none.