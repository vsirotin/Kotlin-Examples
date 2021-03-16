package eu.sirotin.kotlin.examples.high.order.functions

interface Lens<A, B> {
    fun get(a: A) : B
    fun set(a:A, b:B): A

    companion object {
        operator fun<A, B> invoke(get: (A)->B, set: (A, B)->A): Lens<A,B> = object : Lens<A,B> {
            override fun get(a: A): B = get(a)
            override fun set(a: A, b: B): A = set(a, b)
        }
    }
}

infix fun <A, B, C> Lens<A, B>.andThen(other: Lens<B, C>): Lens<A, C> = Lens(
    get = this::get andThen other::get,
    set = { a: A, c: C -> this.set(a, other.set(this.get(a), c))}

/*
    set = { a: A, c: C ->
        val bNew: B = this.get(a)
        val bModified: B = other.set(bNew, c)
        val aModified: A = this.set(a, bModified)
        aModified
    }

 */
)

//Variants
val houseName1: Lens<House, String> = object : Lens<House, String>{
    override fun get(a: House): String = a.streetName

    override fun set(a: House, b: String): House = a.copy(streetName = b)
}

val addressHouse1: Lens<Address, House> = object : Lens<Address, House>{
    override fun get(a: Address): House = a.house

    override fun set(a: Address, b: House): Address = a.copy(house = b)
}

val houseName: Lens<House, String> = Lens<House, String>(get = House::streetName, set = {house, streetName -> house.copy(streetName = streetName)})

val addressHouse: Lens<Address, House> = Lens<Address, House>(get = Address::house, set = {address, house -> address.copy(house = house)})

val addressStreetName = addressHouse andThen houseName

//Test
data class House(val streetName: String, val number: Int)
data class Address(val city: String, val house: House)
data class Company(val name: String, val address: Address)
data class Employee(val name:String, val company: Company)

val employee = Employee("Tom",
    Company("My Firma",
        Address("St. Town",
                House("Market Square",12)
        )
    )
)

fun main() {
    println(employee)

    val emp1 = employee.copy(
            company = employee.company.copy(
                    address = employee.company.address.copy(
                            house = employee.company.address.house.copy(
                                    streetName = "New street"
                            )
                    )
            )
    )

    println(emp1)

    val address1 = Address("Test City",
        House("Test Street", 21))

    println("address1=$address1")

    val adr2 = addressStreetName.set(address1, "New Street")

    println("adr2=$adr2")


}