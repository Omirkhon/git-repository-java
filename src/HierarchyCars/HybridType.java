package HierarchyCars;

public class HybridType extends VehicleTypeByFuelTypes {

    @Override
    public String getTypeName() {
        return VehicleTypeEnum.HYBRID.name();
    }
}
