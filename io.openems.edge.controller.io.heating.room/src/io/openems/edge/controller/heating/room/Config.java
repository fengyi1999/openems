package io.openems.edge.controller.heating.room;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(//
		name = "Controller Heating Room", //
		description = "Controls electric floor and infrared heating in a room")
@interface Config {

	@AttributeDefinition(name = "Component-ID", description = "Unique ID of this Component")
	String id() default "ctrlHeatingRoom0";

	@AttributeDefinition(name = "Alias", description = "Human-readable name of this Component; defaults to Component-ID")
	String alias() default "";

	@AttributeDefinition(name = "Is enabled?", description = "Is this Component enabled?")
	boolean enabled() default true;

	@AttributeDefinition(name = "Mode", description = "Heating control mode")
	Mode mode() default Mode.AUTOMATIC;

	@AttributeDefinition(name = "JSON Schedule in AUTOMATIC Mode", description = "Takes a Json-Array in JSCalendar format")
	String schedule() default "";

	@AttributeDefinition(name = "Low Floor Temperature", description = "The target floor temperature in LOW mode (in 0.1 degree celsius)")
	int lowFloorTemperature();

	@AttributeDefinition(name = "Low Ambient Temperature", description = "The target ambient temperature in LOW mode (in 0.1 degree celsius)")
	int lowAmbientTemperature();

	@AttributeDefinition(name = "High Floor Temperature", description = "The target floor temperature in HIGH mode (in 0.1 degree celsius)")
	int highFloorTemperature();

	@AttributeDefinition(name = "High Ambient Temperature", description = "The target ambient temperature in HIGH mode (in 0.1 degree celsius)")
	int highAmbientTemperature();

	@AttributeDefinition(name = "Floor Thermometer ID", description = "Component-ID of the Floor Thermometer")
	String floorThermometer_id();

	@AttributeDefinition(name = "Ambient Thermometer ID", description = "Component-ID of the Ambient Air Thermometer")
	String ambientThermometer_id();

	@AttributeDefinition(name = "Floor Heating Relay(s)", description = "Channel addresses of the Relays for Floor Heating")
	String[] floorRelays();

	@AttributeDefinition(name = "Infrared Heating Relay(s)", description = "Channel addresses of the Relays for Infrared Heating")
	String[] infraredRelays();

	@AttributeDefinition(name = "Floor Heating Power", description = "The switched power of the floor heating (in Watt)")
	int floorPower();

	@AttributeDefinition(name = "Infrared Heating Power", description = "The switched power of the infrared heating (in Watt)")
	int infraredPower();

	@AttributeDefinition(name = "Has external ambient heating?", description = "Is there an external ambient heating in this room - like a wood stove")
	boolean hasExternalAmbientHeating();

	@AttributeDefinition(name = "Floor Thermometer target filter", description = "This is auto-generated by 'Floor Thermometer ID'")
	String floorThermometer_target() default "(enabled=true)";

	@AttributeDefinition(name = "Ambient Thermometer target filter", description = "This is auto-generated by 'Ambient Thermometer ID'")
	String ambientThermometer_target() default "(enabled=true)";

	@AttributeDefinition(name = "Floor Relay Components target filter", description = "This is auto-generated by 'Floor Heating Relay(s)'")
	String floorRelayComponents_target() default "(enabled=true)";

	@AttributeDefinition(name = "Infrared Relay Components target filter", description = "This is auto-generated by 'Infrared Heating Relay(s)'")
	String infraredRelayComponents_target() default "(enabled=true)";

	String webconsole_configurationFactory_nameHint() default "Controller Heating Room [{id}]";

}