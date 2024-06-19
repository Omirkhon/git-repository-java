package HierarchyCars;

public class ElectricType extends VehicleTypeByFuelTypes {

    @Override
    public String getTypeName() {
        return VehicleTypeEnum.ELECTRIC.name();
    }
}
