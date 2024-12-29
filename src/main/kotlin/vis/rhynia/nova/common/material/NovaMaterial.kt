package vis.rhynia.nova.common.material

import bartworks.system.material.Werkstoff
import gregtech.api.enums.OrePrefixes
import gregtech.api.enums.TextureSet

object NovaMaterial : Runnable {
  private const val OFFSET_ELEMENT = 23000
  private const val OFFSET_MIXTURE = 23100
  private const val OFFSET_PRODUCT = 23200

  private val GenFeaturesUniversal = Werkstoff.GenerationFeatures()
  private val GenFeaturesDustMolten =
      Werkstoff.GenerationFeatures().disable().onlyDust().addMolten()

  // Astrium
  val Astrium: Werkstoff =
      Werkstoff(
          shortArrayOf(30, 144, 252, 255),
          "Astrium",
          "Aμ",
          Werkstoff.Stats()
              .setProtons(170)
              .setMass(452)
              .setBlastFurnace(true)
              .setMeltingPoint(8500),
          Werkstoff.Types.ELEMENT,
          GenFeaturesDustMolten,
          OFFSET_ELEMENT + 1,
          TextureSet.SET_GEM_HORIZONTAL)

  // Astrium Infinity
  val AstriumInfinity: Werkstoff =
      Werkstoff(
          shortArrayOf(0, 191, 255, 255),
          "AstriumInfinity",
          "Aμⁿ",
          Werkstoff.Stats()
              .setProtons(191)
              .setMass(510)
              .setBlastFurnace(true)
              .setMeltingPoint(12560),
          Werkstoff.Types.ELEMENT,
          GenFeaturesDustMolten,
          OFFSET_ELEMENT + 2,
          TextureSet.SET_GEM_VERTICAL)

  // Astrium Magic
  val AstriumMagic: Werkstoff =
      Werkstoff(
          shortArrayOf(0, 32, 178, 170),
          "AstriumMagic",
          "AμMa",
          Werkstoff.Stats().setProtons(170).setMass(475).setBlastFurnace(true).setMeltingPoint(7),
          Werkstoff.Types.ELEMENT,
          GenFeaturesDustMolten,
          OFFSET_ELEMENT + 3,
          TextureSet.SET_DIAMOND)

  // Primoium
  val Primoium =
      Werkstoff(
          shortArrayOf(0x87.toShort(), 0xce.toShort(), 0xeb.toShort()),
          "Primoium",
          "Pr",
          Werkstoff.Stats()
              .setProtons(145)
              .setMass(385)
              .setBlastFurnace(true)
              .setMeltingPoint(7250),
          Werkstoff.Types.ELEMENT,
          Werkstoff.GenerationFeatures().onlyDust().addMolten(),
          OFFSET_ELEMENT + 4,
          TextureSet.SET_SHINY)

  // Originium
  val Originium =
      Werkstoff(
          shortArrayOf(0xda.toShort(), 0xa5.toShort(), 0x20.toShort()),
          "Originium",
          "Or*",
          Werkstoff.Stats()
              .setProtons(165)
              .setMass(445)
              .setBlastFurnace(true)
              .setMeltingPoint(8540),
          Werkstoff.Types.ELEMENT,
          Werkstoff.GenerationFeatures().onlyDust().addMolten(),
          OFFSET_ELEMENT + 5,
          TextureSet.SET_SHINY)

  override fun run() {
    OrePrefixes.entries.forEach { GenFeaturesUniversal.addPrefix(it) }
    GenFeaturesUniversal.removePrefix(OrePrefixes.ore)
  }
}
