package HierarchyCars;

public class DieselType extends VehicleTypeByFuelTypes {

    @Override
    public String getTypeName() {
        return VehicleTypeEnum.DIESEL.name();
    }
}
