object Inventory extends App {
  case class Product(id: Int, name: String, quantity: Int, price: Double)

  val inventory1: Map[Int, Product] = Map(
    101 -> Product(101, "Product 1", 10, 12),
    102 -> Product(102, "Product 2", 5, 25),
    103 -> Product(103, "Product 3", 20, 10.75)
  )

  val inventory2: Map[Int, Product] = Map(
    101 -> Product(103, "Product 3", 10, 22),
    105 -> Product(105, "Product 5", 11, 11)
  )
  def getProductNames(inventory: Map[Int, Product]): List[String] = {
    var productNames = List[String]()
    for ((_, product) <- inventory) {
      productNames = productNames :+ product.name
    }
    productNames
  }

  def calTotalValue(inventory: Map[Int, Product]): Double = {
    var totalValue = 0.0
    for ((_, product) <- inventory) {
      totalValue += product.quantity * product.price
    }
    totalValue
  }

  def isEmpty(inventory: Map[Int, Product]): Boolean = {
    inventory.isEmpty
  }

  def mergeInventories(
      inventory1: Map[Int, Product],
      inventory2: Map[Int, Product]
  ): Map[Int, Product] = {
    var mergedInventory = inventory1

    for ((id, product2) <- inventory2) {
      if (mergedInventory.contains(id)) {
        val product1 = mergedInventory(id)
        val mergedProduct = Product(
          id,
          product1.name,
          product1.quantity + product2.quantity,
          math.max(product1.price, product2.price)
        )
        mergedInventory += (id -> mergedProduct)
      } else {
        mergedInventory += (id -> product2)
      }
    }

    mergedInventory
  }

  def checkAndPrintProduct(
      inventory: Map[Int, Product],
      productId: Int
  ): Unit = {
    var found = false
    for ((id, product) <- inventory if id == productId) {
      found = true
      println(s"Product found: $product")
    }
    if (!found) {
      println(s"Product with ID $productId not found")
    }
  }

  println("Product Names in Inventory1: " + getProductNames(inventory1))
  println("Product Names in Inventory1: " + getProductNames(inventory2))
  println("Total Value of Inventory1: " + calTotalValue(inventory1))
  println("Is Inventory1 empty? " + isEmpty(inventory1))

  val mergedInventory = mergeInventories(inventory1, inventory2)
  println("Merged Inventory: " + mergedInventory)

  checkAndPrintProduct(inventory1, 102)

}
