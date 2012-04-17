// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Map;

// Referenced classes of package net.minecraft.src:
//            BlockAetherPortal, mod_Aether, Block, BlockAetherDirt, 
//            BlockAetherGrass, BlockQuicksoil, BlockHolystone, BlockIcestone, 
//            BlockFreezer, BlockAetherFlower, BlockAercloud, BlockAerogel, 
//            BlockQuicksoilGlass, BlockAetherLog, AetherBlock, Material, 
//            BlockAetherLeaves, BlockAetherSapling, BlockAmbrosiumOre, BlockAmbrosiumTorch, 
//            BlockZaniteOre, BlockZanite, BlockFloating, BlockEnchantedGravitite, 
//            BlockEnchanter, BlockIncubator, BlockTrap, BlockChestMimic, 
//            BlockTreasureChest, BlockDungeon, BlockPillar, BlockAetherBed, 
//            ChristmasLeaves, BlockPresent, BlockBerryBush, BlockBushStem, 
//            BlockBlueLeaves, ItemBlockHolystone, ModLoader, ItemBlockAetherGrass, 
//            ItemBlockAercloud, ItemBlockAetherLog, ItemDungeonBlock, ItemBlockQuicksoil, 
//            TileEntityIncubator, TileEntityEnchanter, TileEntityFreezer, TileEntityTreasureChest, 
//            TileEntityTreasureChestRender, EntityMimic, ItemStack, EntityFloatingBlock, 
//            RenderFloatingBlock, RenderMimic

public class AetherBlocks
{

    public static final String dir = "/aether/blocks/";
    public static Block Portal;
    public static Block Dirt;
    public static Block Grass;
    public static Block Quicksoil;
    public static Block Holystone;
    public static Block Icestone;
    public static Block Aercloud;
    public static Block Aerogel;
    public static Block Log;
    public static Block Plank;
    public static Block SkyrootLeaves;
    public static Block GoldenOakLeaves;
    public static Block SkyrootSapling;
    public static Block GoldenOakSapling;
    public static Block AmbrosiumOre;
    public static Block AmbrosiumTorch;
    public static Block ZaniteOre;
    public static Block GravititeOre;
    public static Block EnchantedGravitite;
    public static Block Enchanter;
    public static Block Incubator;
    public static Block Trap;
    public static Block ChestMimic;
    public static Block TreasureChest;
    public static Block DungeonStone;
    public static Block LightDungeonStone;
    public static Block LockedDungeonStone;
    public static Block LockedLightDungeonStone;
    public static Block Pillar;
    public static Block ZaniteBlock;
    public static Block QuicksoilGlass;
    public static Block Freezer;
    public static Block WhiteFlower;
    public static Block PurpleFlower;
    public static Block Bed;
    public static Block ChristmasLeaves;
    public static Block blockPresent;
    public static Block BerryBush;
    public static Block BushStem;
    public static Block BlueLeaves;

    public AetherBlocks()
    {
        Portal = (new BlockAetherPortal(mod_Aether.idBlockAetherPortal)).setHardness(-1F).setResistance(6000000F).setBlockName("AetherPortal");
        Dirt = (new BlockAetherDirt(mod_Aether.idBlockAetherDirt)).setHardness(0.2F).setStepSound(Block.soundGravelFootstep).setBlockName("AetherDirt");
        Grass = (new BlockAetherGrass(mod_Aether.idBlockAetherGrass)).setHardness(0.2F).setStepSound(Block.soundGrassFootstep).setBlockName("AetherGrass");
        Quicksoil = (new BlockQuicksoil(mod_Aether.idBlockQuicksoil)).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setBlockName("Quicksoil");
        Holystone = (new BlockHolystone(mod_Aether.idBlockHolystone)).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("Holystone");
        Icestone = (new BlockIcestone(mod_Aether.idBlockIcestone)).setHardness(3F).setStepSound(Block.soundGlassFootstep).setBlockName("Icestone");
        Freezer = (new BlockFreezer(mod_Aether.idBlockFreezer)).setHardness(2.5F).setStepSound(Block.soundStoneFootstep).setBlockName("Freezer");
        WhiteFlower = (new BlockAetherFlower(mod_Aether.idBlockWhiteFlower, 43)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("White_Flower");
        PurpleFlower = (new BlockAetherFlower(mod_Aether.idBlockPurpleFlower, 36)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("Purple_Flower");
        Aercloud = (new BlockAercloud(mod_Aether.idBlockAercloud)).setHardness(0.2F).setLightOpacity(3).setStepSound(Block.soundClothFootstep).setBlockName("Aercloud");
        Aerogel = (new BlockAerogel(mod_Aether.idBlockAerogel)).setHardness(1.0F).setResistance(2000F).setLightOpacity(3).setStepSound(Block.soundStoneFootstep).setBlockName("Aerogel");
        QuicksoilGlass = (new BlockQuicksoilGlass(mod_Aether.idBlockQuicksoilGlass)).setLightValue(0.7375F).setHardness(0.2F).setLightOpacity(0).setStepSound(Block.soundGlassFootstep).setBlockName("QuicksoilGlass");
        Log = (new BlockAetherLog(mod_Aether.idBlockLog)).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setBlockName("AetherLog");
        Plank = (new AetherBlock(mod_Aether.idBlockPlank, 34, Material.wood)).setHardness(2.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setBlockName("AetherPlank");
        SkyrootLeaves = (new BlockAetherLeaves(mod_Aether.idBlockSkyrootLeaves)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setBlockName("SkyrootLeaves");
        GoldenOakLeaves = (new BlockAetherLeaves(mod_Aether.idBlockGoldenOakLeaves)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setBlockName("GoldenLeaves");
        SkyrootSapling = (new BlockAetherSapling(mod_Aether.idBlockSkyrootSapling)).setBlockName("SkyrootSapling").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
        GoldenOakSapling = (new BlockAetherSapling(mod_Aether.idBlockGoldenOakSapling)).setBlockName("GoldenOakSapling").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
        AmbrosiumOre = (new BlockAmbrosiumOre(mod_Aether.idBlockAmbrosiumOre)).setHardness(3F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setBlockName("AmbrosiumOre");
        AmbrosiumTorch = (new BlockAmbrosiumTorch(mod_Aether.idBlockAmbrosiumTorch)).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setBlockName("AmbrosiumTorch");
        int i = Block.blockSteel.blockIndexInTexture;
        ZaniteOre = (new BlockZaniteOre(mod_Aether.idBlockZaniteOre)).setHardness(3F).setStepSound(Block.soundStoneFootstep).setBlockName("ZaniteOre");
        ZaniteBlock = (new BlockZanite(mod_Aether.idBlockZanite, i)).setHardness(3F).setStepSound(Block.soundStoneFootstep).setBlockName("ZaniteBlock");
        GravititeOre = (new BlockFloating(mod_Aether.idBlockGravititeOre, 17, false)).setHardness(5F).setStepSound(Block.soundStoneFootstep).setBlockName("GravititeOre");
        EnchantedGravitite = (new BlockEnchantedGravitite(mod_Aether.idBlockEnchantedGravitite, i, true)).setHardness(5F).setStepSound(Block.soundStoneFootstep).setBlockName("EnchantedGravitite");
        Enchanter = (new BlockEnchanter(mod_Aether.idBlockEnchanter)).setBlockName("Enchanter").setHardness(2.0F);
        Incubator = (new BlockIncubator(mod_Aether.idBlockIncubator)).setBlockName("Incubator").setHardness(2.0F);
        Trap = (new BlockTrap(mod_Aether.idBlockTrap)).setHardness(-1F).setResistance(1000000F).setStepSound(Block.soundStoneFootstep).setBlockName("Trap");
        ChestMimic = (new BlockChestMimic(mod_Aether.idBlockChestMimic)).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setBlockName("Mimic");
        TreasureChest = (new BlockTreasureChest(mod_Aether.idBlockTreasureChest, 28, 29)).setHardness(-1F).setStepSound(Block.soundStoneFootstep).setBlockName("TreasureChest");
        DungeonStone = (new BlockDungeon(mod_Aether.idBlockDungeonStone)).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("DungeonStone");
        LightDungeonStone = (new BlockDungeon(mod_Aether.idBlockLightDungeonStone)).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setLightValue(0.75F).setBlockName("LightDungeonStone");
        LockedDungeonStone = (new BlockDungeon(mod_Aether.idBlockLockedDungeonStone)).setHardness(-1F).setResistance(1000000F).setStepSound(Block.soundStoneFootstep).setBlockName("LockedDungeonStone");
        LockedLightDungeonStone = (new BlockDungeon(mod_Aether.idBlockLockedLightDungeonStone)).setHardness(-1F).setResistance(1000000F).setStepSound(Block.soundStoneFootstep).setLightValue(0.5F).setBlockName("LightLockedDungeonStone");
        Pillar = (new BlockPillar(mod_Aether.idBlockPillar)).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("Pillar");
        Bed = (new BlockAetherBed(mod_Aether.idBlockAetherBed)).setHardness(0.2F).setBlockName("AetherBed").disableStats().setRequiresSelfNotify();
        ChristmasLeaves = (new ChristmasLeaves(mod_Aether.idBlockChristmasLeaves)).setBlockName("Christmas Leaves").setHardness(0.2F).setStepSound(Block.soundGrassFootstep).setLightOpacity(1);
        blockPresent = (new BlockPresent(mod_Aether.idBlockPresent)).setBlockName("Present").setHardness(0.1F).setStepSound(Block.soundGrassFootstep);
        BerryBush = (new BlockBerryBush(mod_Aether.idBerryBush)).setBlockName("Berry Bush").setHardness(0.2F).setStepSound(Block.soundGrassFootstep);
        BushStem = (new BlockBushStem(mod_Aether.idBushStem)).setBlockName("Bush Stem").setHardness(0.2F).setStepSound(Block.soundGrassFootstep);
        BlueLeaves = (new BlockBlueLeaves(mod_Aether.idBlockBlueLeaves)).setBlockName("Blue Leaves").setHardness(0.2F).setStepSound(Block.soundGrassFootstep);
        RegisterBlocks(new Block[] {
            Portal, Dirt, Icestone, Aerogel, Plank, SkyrootLeaves, GoldenOakLeaves, SkyrootSapling, GoldenOakSapling, AmbrosiumOre, 
            AmbrosiumTorch, ZaniteOre, GravititeOre, EnchantedGravitite, Enchanter, Incubator, Trap, ChestMimic, TreasureChest, ZaniteBlock, 
            QuicksoilGlass, Freezer, WhiteFlower, PurpleFlower
        });
        ModLoader.RegisterBlock(Holystone, net.minecraft.src.ItemBlockHolystone.class);
        ModLoader.RegisterBlock(Grass, net.minecraft.src.ItemBlockAetherGrass.class);
        ModLoader.RegisterBlock(Aercloud, net.minecraft.src.ItemBlockAercloud.class);
        ModLoader.RegisterBlock(Log, net.minecraft.src.ItemBlockAetherLog.class);
        ModLoader.RegisterBlock(DungeonStone, net.minecraft.src.ItemDungeonBlock.class);
        ModLoader.RegisterBlock(LightDungeonStone, net.minecraft.src.ItemDungeonBlock.class);
        ModLoader.RegisterBlock(Pillar, net.minecraft.src.ItemDungeonBlock.class);
        ModLoader.RegisterBlock(Quicksoil, net.minecraft.src.ItemBlockQuicksoil.class);
        ModLoader.RegisterBlock(ChristmasLeaves);
        ModLoader.RegisterBlock(BlueLeaves);
        ModLoader.RegisterBlock(blockPresent);
        ModLoader.RegisterBlock(BerryBush);
        ModLoader.RegisterBlock(BushStem);
        ModLoader.RegisterTileEntity(net.minecraft.src.TileEntityIncubator.class, "Incubator");
        ModLoader.RegisterTileEntity(net.minecraft.src.TileEntityEnchanter.class, "Enchanter");
        ModLoader.RegisterTileEntity(net.minecraft.src.TileEntityFreezer.class, "Freezer");
        ModLoader.RegisterTileEntity(net.minecraft.src.TileEntityTreasureChest.class, "Treasure Chest", new TileEntityTreasureChestRender());
        ModLoader.RegisterEntityID(net.minecraft.src.EntityMimic.class, "Mimic", ModLoader.getUniqueEntityId());
        ModLoader.AddName(ChristmasLeaves, "Christmas Leaves");
        ModLoader.AddName(blockPresent, "Present");
        ModLoader.AddName(BerryBush, "Berry Bush");
        ModLoader.AddName(BushStem, "Bush Stem");
        ModLoader.AddName(BlueLeaves, "Blue Leaves");
        ModLoader.AddName(Portal, "Aether Portal");
        ModLoader.AddName(Dirt, "Aether Dirt");
        ModLoader.AddName(new ItemStack(Grass, 1, 0), "Aether Grass");
        ModLoader.AddName(new ItemStack(Grass, 1, 1), "Enchanted Aether Grass");
        ModLoader.AddName(Quicksoil, "Quicksoil");
        ModLoader.AddName(new ItemStack(Holystone, 1, 0), "Holystone");
        ModLoader.AddName(new ItemStack(Holystone, 1, 2), "Mossy Holystone");
        ModLoader.AddName(Icestone, "Icestone");
        ModLoader.AddName(new ItemStack(Aercloud, 1, 0), "Cold Aercloud");
        ModLoader.AddName(new ItemStack(Aercloud, 1, 1), "Blue Aercloud");
        ModLoader.AddName(new ItemStack(Aercloud, 1, 2), "Gold Aercloud");
        ModLoader.AddName(Aerogel, "\247aAerogel");
        ModLoader.AddName(new ItemStack(Log, 1, 0), "Skyroot Log");
        ModLoader.AddName(new ItemStack(Log, 1, 2), "Golden Oak Log");
        ModLoader.AddName(SkyrootLeaves, "Skyroot Leaves");
        ModLoader.AddName(GoldenOakLeaves, "Golden Oak Leaves");
        ModLoader.AddName(Plank, "Skyroot Plank");
        ModLoader.AddName(SkyrootSapling, "Skyroot Sapling");
        ModLoader.AddName(GoldenOakSapling, "Golden Oak Sapling");
        ModLoader.AddName(AmbrosiumOre, "Ambrosium Ore");
        ModLoader.AddName(AmbrosiumTorch, "Ambrosium Torch");
        ModLoader.AddName(ZaniteOre, "Zanite Ore");
        ModLoader.AddName(GravititeOre, "Gravitite Ore");
        ModLoader.AddName(EnchantedGravitite, "\247bEnchanted Gravitite");
        ModLoader.AddName(Trap, "Trap");
        ModLoader.AddName(ChestMimic, "Wooden Chest");
        ModLoader.AddName(TreasureChest, "Treasure Chest");
        ModLoader.AddName(Enchanter, "Altar");
        ModLoader.AddName(Incubator, "Incubator");
        ModLoader.AddName(ZaniteBlock, "Zanite Block");
        ModLoader.AddName(QuicksoilGlass, "\247bQuicksoil Glass");
        ModLoader.AddName(Freezer, "Freezer");
        ModLoader.AddName(WhiteFlower, "White Flower");
        ModLoader.AddName(PurpleFlower, "Purple Flower");
        ModLoader.AddName(new ItemStack(DungeonStone, 1, 0), "Carved Stone");
        ModLoader.AddName(new ItemStack(DungeonStone, 1, 1), "Angelic Stone");
        ModLoader.AddName(new ItemStack(DungeonStone, 1, 2), "Hellfire Stone");
        ModLoader.AddName(new ItemStack(LightDungeonStone, 1, 0), "Sentry Stone");
        ModLoader.AddName(new ItemStack(LightDungeonStone, 1, 1), "Light Angelic Stone");
        ModLoader.AddName(new ItemStack(LightDungeonStone, 1, 2), "Light Hellfire Stone");
        ModLoader.AddName(new ItemStack(Pillar, 1, 0), "Pillar");
        ModLoader.AddName(new ItemStack(Pillar, 1, 1), "Pillar Top");
        ModLoader.AddName(new ItemStack(Pillar, 1, 2), "Pillar Top");
    }

    public static void AddRenderer(Map map)
    {
        map.put(net.minecraft.src.EntityFloatingBlock.class, new RenderFloatingBlock());
        map.put(net.minecraft.src.EntityMimic.class, new RenderMimic());
    }

    public static boolean isGood(int i, int j)
    {
        return i == 0 || i == Aercloud.blockID;
    }

    public static boolean isEarth(int i, int j)
    {
        return i == Dirt.blockID || i == Grass.blockID || i == Holystone.blockID && j <= 1;
    }

    public void RegisterBlocks(Block ablock[])
    {
        Block ablock1[] = ablock;
        int i = ablock1.length;
        for(int j = 0; j < i; j++)
        {
            Block block = ablock1[j];
            ModLoader.RegisterBlock(block);
        }

    }

    public int override(String s)
    {
        return ModLoader.addOverride("/terrain.png", (new StringBuilder()).append("/aether/blocks/").append(s).toString());
    }
}
