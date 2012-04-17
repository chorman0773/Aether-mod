// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.MinecraftForgeClient;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import paulscode.sound.SoundSystem;

// Referenced classes of package net.minecraft.src:
//            BaseMod, IBlockSet, SAPI, ModLoader, 
//            KeyBinding, DimensionAether, PlayerBaseAether, PlayerAPI, 
//            BiomeGenAether, BiomeGenBase, AetherBlocks, AetherItems, 
//            AetherMobs, AetherPoison, AetherAchievements, AetherRecipes, 
//            RenderBlocks, Tessellator, Block, EntityPlayer, 
//            ItemStack, InventoryPlayer, SoundManager, Aether_SoundManager, 
//            SoundPool, IAetherBoss, Entity, EntityPlayerSP, 
//            World, AetherNBT, WorldInfo, GuiMainMenu, 
//            NBTTagCompound, EntityCloudParachute, BlockAetherPortal, DimensionBase, 
//            GameSettings, Item, StatFileWriter, GuiInventory, 
//            GuiInventoryMoreSlots, ScaledResolution, RenderEngine, AxisAlignedBB, 
//            EntityProjectileBase, EntityArrow, PlayerController, EntityMoa, 
//            MoaColour, FontRenderer, RenderPlayerAether, BlockFire, 
//            BlockPortal, MathHelper, IBlockAccess, Achievement

public class mod_Aether extends BaseMod
    implements IBlockSet
{

    public static DimensionAether dim;
    private static World world;
    private static World nbtWorld;
    private static long clock;
    private boolean cloudPara;
    private Random rand;
    private float zLevel;
    private int updateCounter;
    public static int renderID;
    public static int raritySwet = 8;
    public static int rarityAechorPlant = 8;
    public static int rarityCockatrice = 3;
    public static int rarityAerwhale = 8;
    public static int rarityZephyr = 5;
    public static int raritySheepuff = 10;
    public static int rarityPhyg = 12;
    public static int rarityMoa = 10;
    public static int rarityFlyingCow = 10;
    public static int rarityWhirlwind = 8;
    public static int rarityAerbunny = 11;
    public static boolean worldMenu = true;
    public static boolean aetherMenu = true;
    public static boolean TMIhidden = true;
    public static boolean christmasContent = true;
    private static boolean tryReplaceSoundManager = false;
    public static int replaceSndManager = 1;
    public static int idBlockAetherPortal = 165;
    public static int idBlockAetherDirt = 166;
    public static int idBlockAetherGrass = 167;
    public static int idBlockQuicksoil = 168;
    public static int idBlockHolystone = 169;
    public static int idBlockIcestone = 170;
    public static int idBlockAercloud = 171;
    public static int idBlockAerogel = 172;
    public static int idBlockEnchanter = 173;
    public static int idBlockIncubator = 174;
    public static int idBlockLog = 175;
    public static int idBlockPlank = 176;
    public static int idBlockSkyrootLeaves = 177;
    public static int idBlockGoldenOakLeaves = 178;
    public static int idBlockSkyrootSapling = 179;
    public static int idBlockGoldenOakSapling = 180;
    public static int idBlockAmbrosiumOre = 181;
    public static int idBlockAmbrosiumTorch = 182;
    public static int idBlockZaniteOre = 183;
    public static int idBlockGravititeOre = 184;
    public static int idBlockEnchantedGravitite = 185;
    public static int idBlockTrap = 186;
    public static int idBlockChestMimic = 187;
    public static int idBlockTreasureChest = 188;
    public static int idBlockDungeonStone = 189;
    public static int idBlockLightDungeonStone = 190;
    public static int idBlockLockedDungeonStone = 191;
    public static int idBlockLockedLightDungeonStone = 192;
    public static int idBlockPillar = 193;
    public static int idBlockZanite = 194;
    public static int idBlockQuicksoilGlass = 195;
    public static int idBlockFreezer = 196;
    public static int idBlockWhiteFlower = 197;
    public static int idBlockPurpleFlower = 198;
    public static int idBlockAetherBed = 199;
    public static int idBlockChristmasLeaves = 200;
    public static int idBlockPresent = 201;
    public static int idBerryBush = 202;
    public static int idBushStem = 203;
    public static int idBlockBlueLeaves = 204;
    public static int idItemVictoryMedal = 17000;
    public static int idItemKey = 17001;
    public static int idItemLoreBook = 17002;
    public static int idItemMoaEgg = 17003;
    public static int idItemBlueMusicDisk = 17004;
    public static int idItemGoldenAmber = 17005;
    public static int idItemAechorPetal = 17006;
    public static int idItemStick = 17007;
    public static int idItemDart = 17008;
    public static int idItemDartShooter = 17009;
    public static int idItemAmbrosiumShard = 17010;
    public static int idItemZanite = 17011;
    public static int idItemBucket = 17012;
    public static int idItemPickSkyroot = 17013;
    public static int idItemPickHolystone = 17014;
    public static int idItemPickZanite = 17015;
    public static int idItemPickGravitite = 17016;
    public static int idItemShovelSkyroot = 17017;
    public static int idItemShovelHolystone = 17018;
    public static int idItemShovelZanite = 17019;
    public static int idItemShovelGravitite = 17020;
    public static int idItemAxeSkyroot = 17021;
    public static int idItemAxeHolystone = 17022;
    public static int idItemAxeZanite = 17023;
    public static int idItemAxeGravitite = 17024;
    public static int idItemSwordSkyroot = 17025;
    public static int idItemSwordHolystone = 17026;
    public static int idItemSwordZanite = 17027;
    public static int idItemSwordGravitite = 17028;
    public static int idItemIronBubble = 17029;
    public static int idItemPigSlayer = 17030;
    public static int idItemVampireBlade = 17031;
    public static int idItemNatureStaff = 17032;
    public static int idItemSwordFire = 17033;
    public static int idItemSwordHoly = 17034;
    public static int idItemSwordLightning = 17035;
    public static int idItemLightningKnife = 17036;
    public static int idItemGummieSwet = 17037;
    public static int idItemHammerNotch = 17038;
    public static int idItemPhoenixBow = 17039;
    public static int idItemCloudParachute = 17040;
    public static int idItemCloudParachuteGold = 17041;
    public static int idItemCloudStaff = 17042;
    public static int idItemLifeShard = 17043;
    public static int idItemGoldenFeather = 17044;
    public static int idItemLance = 17045;
    public static int idItemIronRing = 17046;
    public static int idItemGoldRing = 17047;
    public static int idItemZaniteRing = 17048;
    public static int idItemIronPendant = 17049;
    public static int idItemGoldPendant = 17050;
    public static int idItemZanitePendant = 17051;
    public static int idItemRepShield = 17052;
    public static int idItemAetherCape = 17053;
    public static int idItemLeatherGlove = 17054;
    public static int idItemIronGlove = 17055;
    public static int idItemGoldGlove = 17056;
    public static int idItemDiamondGlove = 17057;
    public static int idItemZaniteGlove = 17058;
    public static int idItemZaniteHelmet = 17059;
    public static int idItemZaniteChestplate = 17060;
    public static int idItemZaniteLeggings = 17061;
    public static int idItemZaniteBoots = 17062;
    public static int idItemGravititeGlove = 17063;
    public static int idItemGravititeHelmet = 17064;
    public static int idItemGravititeBodyplate = 17065;
    public static int idItemGravititePlatelegs = 17066;
    public static int idItemGravititeBoots = 17067;
    public static int idItemPhoenixGlove = 17068;
    public static int idItemPhoenixHelm = 17069;
    public static int idItemPhoenixBody = 17070;
    public static int idItemPhoenixLegs = 17071;
    public static int idItemPhoenixBoots = 17072;
    public static int idItemObsidianGlove = 17073;
    public static int idItemObsidianBody = 17074;
    public static int idItemObsidianHelm = 17075;
    public static int idItemObsidianLegs = 17076;
    public static int idItemObsidianBoots = 17077;
    public static int idItemNeptuneGlove = 17078;
    public static int idItemNeptuneHelmet = 17079;
    public static int idItemNeptuneChestplate = 17080;
    public static int idItemNeptuneLeggings = 17081;
    public static int idItemNeptuneBoots = 17082;
    public static int idItemRegenerationStone = 17083;
    public static int idItemInvisibilityCloak = 17084;
    public static int idItemAgilityCape = 17085;
    public static int idItemWhiteCape = 17086;
    public static int idItemRedCape = 17087;
    public static int idItemYellowCape = 17088;
    public static int idItemBlueCape = 17089;
    public static int idItemPickValkyrie = 17090;
    public static int idItemAxeValkyrie = 17091;
    public static int idItemShovelValkyrie = 17092;
    public static int idItemHealingStone = 17093;
    public static int idItemIceRing = 17094;
    public static int idItemIcePendant = 17095;
    public static int idBlueBerry = 17096;
    public static int idGingerBreadMan = 17097;
    public static int idCandyCane = 17098;
    public static int idCandySword = 17099;
    public static int idWhiteBerry = 17100;
    public static int idSwetBall = 17101;
    public static boolean hasLoreOverworld = false;
    public static boolean hasLoreNether = false;
    public static boolean hasLoreAether = false;
    public static IAetherBoss currentBoss = null;
    public static PlayerBaseAether Player;
    Minecraft mc;
    private KeyBinding key_loreGain;

    public mod_Aether()
    {
        cloudPara = false;
        rand = new Random();
        zLevel = -90F;
        mc = ModLoader.getMinecraftInstance();
        key_loreGain = new KeyBinding("key.loreGain", 48);
    }

    public void load()
    {
        renderID = ModLoader.getUniqueBlockModelID(this, true);
        MinecraftForgeClient.preloadTexture("/aetherBlocks.png");
        MinecraftForgeClient.preloadTexture("/aetherItems.png");
        MinecraftForgeClient.preloadTexture("/terrain.png");
        dim = new DimensionAether();
        PlayerAPI.register("Aether", net.minecraft.src.PlayerBaseAether.class);
        dim.name = "Aether";
        BiomeGenBase biomegenbase = (new BiomeGenAether()).setDisableRain();
        try
        {
            ModLoader.setPrivateValue(net.minecraft.src.BiomeGenBase.class, biomegenbase, "w", Boolean.valueOf(false));
        }
        catch(Exception exception)
        {
            System.out.println("Forgot to update reflection. Trying MCP name for disabling rain.");
            try
            {
                ModLoader.setPrivateValue(net.minecraft.src.BiomeGenBase.class, biomegenbase, "enableRain", Boolean.valueOf(false));
            }
            catch(Exception exception1) { }
        }
        new AetherBlocks();
        new AetherItems();
        new AetherMobs();
        new AetherPoison();
        new AetherAchievements();
        new AetherRecipes();
        SAPI.BlockSet.add(this);
        ModLoader.RegisterKey(this, key_loreGain, false);
        ModLoader.AddLocalization("key.loreGain", "Gain Lore");
        ModLoader.SetInGameHook(this, true, false);
        SAPI.Harvest harvest = new SAPI.Harvest();
    }

    public boolean RenderWorldBlock(RenderBlocks renderblocks, IBlockAccess iblockaccess, int i, int j, int k, Block block, int l)
    {
        if(l == renderID)
        {
            renderblocks.overrideBlockTexture = 49;
            renderblocks.renderBlockReed(block, i, j, k);
            renderblocks.overrideBlockTexture = -1;
            renderblocks.renderStandardBlock(block, i, j, k);
            return true;
        } else
        {
            return false;
        }
    }

    public void RenderInvBlock(RenderBlocks renderblocks, Block block, int i, int j)
    {
        if(j == renderID)
        {
            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1F, 0.0F);
            renderblocks.overrideBlockTexture = 49;
            renderblocks.renderCrossedSquares(block, i, -0.5D, -0.5D, -0.5D);
            tessellator.draw();
            renderblocks.overrideBlockTexture = -1;
            block.setBlockBoundsForItemRender();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1F, 0.0F);
            renderblocks.renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(0, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 1.0F, 0.0F);
            renderblocks.renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(1, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, -1F);
            renderblocks.renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(2, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, 1.0F);
            renderblocks.renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(3, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1F, 0.0F, 0.0F);
            renderblocks.renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(4, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0F, 0.0F, 0.0F);
            renderblocks.renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(5, i));
            tessellator.draw();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        }
    }

    public void KeyboardEvent(KeyBinding keybinding)
    {
        Minecraft minecraft = ModLoader.getMinecraftInstance();
        if(keybinding == key_loreGain)
        {
            EntityPlayerSP entityplayersp = ModLoader.getMinecraftInstance().thePlayer;
            if(getCurrentDimension() == 3)
            {
                ((EntityPlayer) (entityplayersp)).inventory.addItemStackToInventory(new ItemStack(AetherItems.LoreBook, 1, 2));
            } else
            if(getCurrentDimension() == 0)
            {
                ((EntityPlayer) (entityplayersp)).inventory.addItemStackToInventory(new ItemStack(AetherItems.LoreBook, 1, 0));
            } else
            if(getCurrentDimension() == -1)
            {
                ((EntityPlayer) (entityplayersp)).inventory.addItemStackToInventory(new ItemStack(AetherItems.LoreBook, 1, 1));
            }
        }
    }

    public boolean OnTickInGame(float f, Minecraft minecraft)
    {
        if(!tryReplaceSoundManager && replaceSndManager == 1 && (mc.sndManager instanceof SoundManager) && !(mc.sndManager instanceof Aether_SoundManager))
        {
            System.out.print("Overriding with new SoundManager");
            SoundManager soundmanager = mc.sndManager;
            Aether_SoundManager aether_soundmanager = new Aether_SoundManager();
            SoundSystem soundsystem = null;
            try
            {
                soundsystem = (SoundSystem)ModLoader.getPrivateValue(net.minecraft.src.SoundManager.class, mc.sndManager, "sndSystem");
                aether_soundmanager.soundPoolSounds = (SoundPool)ModLoader.getPrivateValue(net.minecraft.src.SoundManager.class, mc.sndManager, "soundPoolSounds");
                aether_soundmanager.soundPoolStreaming = (SoundPool)ModLoader.getPrivateValue(net.minecraft.src.SoundManager.class, mc.sndManager, "soundPoolStreaming");
                aether_soundmanager.soundPoolMusic = (SoundPool)ModLoader.getPrivateValue(net.minecraft.src.SoundManager.class, mc.sndManager, "soundPoolMusic");
            }
            catch(Exception exception)
            {
                try
                {
                    soundsystem = (SoundSystem)ModLoader.getPrivateValue(net.minecraft.src.SoundManager.class, mc.sndManager, "a");
                    aether_soundmanager.soundPoolSounds = (SoundPool)ModLoader.getPrivateValue(net.minecraft.src.SoundManager.class, mc.sndManager, "b");
                    aether_soundmanager.soundPoolStreaming = (SoundPool)ModLoader.getPrivateValue(net.minecraft.src.SoundManager.class, mc.sndManager, "c");
                    aether_soundmanager.soundPoolMusic = (SoundPool)ModLoader.getPrivateValue(net.minecraft.src.SoundManager.class, mc.sndManager, "d");
                }
                catch(Exception exception2)
                {
                    exception2.printStackTrace();
                }
            }
            aether_soundmanager.loadSoundSettings(mc.gameSettings, soundsystem);
            try
            {
                mc.sndManager = aether_soundmanager;
                System.out.println("SoundManager replaced successfully!");
            }
            catch(Exception exception1)
            {
                mc.sndManager = soundmanager;
                System.out.println("SoundManager replaced unsuccessfully!");
                exception1.printStackTrace();
            }
            tryReplaceSoundManager = true;
        }
        if(currentBoss != null)
        {
            Entity entity = currentBoss.GetEntity();
            if(Math.sqrt(Math.pow(entity.posX - minecraft.thePlayer.posX, 2D) + Math.pow(entity.posY - minecraft.thePlayer.posY, 2D) + Math.pow(entity.posZ - minecraft.thePlayer.posZ, 2D)) > 50D)
            {
                currentBoss = null;
            }
        }
        if(!minecraft.theWorld.multiplayerWorld)
        {
            if(minecraft.theWorld != nbtWorld)
            {
                if(nbtWorld != null)
                {
                    AetherNBT.save(nbtWorld);
                }
                if(minecraft.theWorld != null)
                {
                    AetherNBT.load(minecraft.theWorld);
                }
                nbtWorld = minecraft.theWorld;
            }
            if(nbtWorld != null && nbtWorld.worldInfo.getWorldTime() % (long)nbtWorld.autosavePeriod == 0L)
            {
                AetherNBT.save(nbtWorld);
            }
        }
        if(!(minecraft.currentScreen instanceof GuiMainMenu))
        {
            GuiMainMenu.mmactive = false;
        }
        if(minecraft.thePlayer != null)
        {
            EntityPlayerSP entityplayersp = minecraft.thePlayer;
            if(((EntityPlayer) (entityplayersp)).dimension == dim.number && ((EntityPlayer) (entityplayersp)).posY < -2D && !GuiMainMenu.mmactive)
            {
                Class class1 = null;
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                if(((EntityPlayer) (entityplayersp)).ridingEntity != null)
                {
                    class1 = ((EntityPlayer) (entityplayersp)).ridingEntity.getClass();
                    ((EntityPlayer) (entityplayersp)).ridingEntity.writeToNBT(nbttagcompound);
                    ((EntityPlayer) (entityplayersp)).ridingEntity.setEntityDead();
                }
                double d = ((EntityPlayer) (entityplayersp)).motionY;
                cloudPara = false;
                if(EntityCloudParachute.getCloudBelongingToEntity(entityplayersp) != null)
                {
                    cloudPara = true;
                }
                DimensionBase.usePortal(((BlockAetherPortal)AetherBlocks.Portal).getDimNumber());
                minecraft.thePlayer.setLocationAndAngles(((EntityPlayer) (entityplayersp)).posX, 127D, ((EntityPlayer) (entityplayersp)).posZ, ((EntityPlayer) (entityplayersp)).rotationYaw, 0.0F);
                if(class1 != null && !minecraft.theWorld.multiplayerWorld)
                {
                    Object obj = null;
                    try
                    {
                        Entity entity1 = (Entity)class1.getDeclaredConstructor(new Class[] {
                            net.minecraft.src.World.class
                        }).newInstance(new Object[] {
                            minecraft.theWorld
                        });
                        entity1.readFromNBT(nbttagcompound);
                        entity1.setLocationAndAngles(((EntityPlayer) (entityplayersp)).posX, 127D, ((EntityPlayer) (entityplayersp)).posZ, ((EntityPlayer) (entityplayersp)).rotationYaw, 0.0F);
                        minecraft.theWorld.spawnEntityInWorld(entity1);
                        entityplayersp.mountEntity(entity1);
                    }
                    catch(Exception exception3)
                    {
                        System.out.println("Failed to transfer mount.");
                    }
                }
                entityplayersp.motionX = entityplayersp.motionZ = 0.0D;
                entityplayersp.motionY = d;
                if(cloudPara && EntityCloudParachute.entityHasRoomForCloud(minecraft.theWorld, entityplayersp))
                {
                    for(int k = 0; k < 32; k++)
                    {
                        EntityCloudParachute.doCloudSmoke(minecraft.theWorld, entityplayersp);
                    }

                    minecraft.theWorld.playSoundAtEntity(entityplayersp, "cloud", 1.0F, 1.0F / (minecraft.theWorld.rand.nextFloat() * 0.1F + 0.95F));
                    if(!minecraft.theWorld.multiplayerWorld)
                    {
                        minecraft.theWorld.spawnEntityInWorld(new EntityCloudParachute(minecraft.theWorld, entityplayersp, false));
                    }
                }
                if(minecraft.gameSettings.difficulty == 0)
                {
                    entityplayersp.fallDistance = -64F;
                }
                if(!cloudPara)
                {
                    if(((EntityPlayer) (entityplayersp)).inventory.consumeInventoryItem(AetherItems.CloudParachute.shiftedIndex))
                    {
                        if(EntityCloudParachute.entityHasRoomForCloud(minecraft.theWorld, entityplayersp))
                        {
                            for(int i1 = 0; i1 < 32; i1++)
                            {
                                EntityCloudParachute.doCloudSmoke(minecraft.theWorld, entityplayersp);
                            }

                            minecraft.theWorld.playSoundAtEntity(entityplayersp, "cloud", 1.0F, 1.0F / (minecraft.theWorld.rand.nextFloat() * 0.1F + 0.95F));
                            if(!minecraft.theWorld.multiplayerWorld)
                            {
                                minecraft.theWorld.spawnEntityInWorld(new EntityCloudParachute(minecraft.theWorld, entityplayersp, false));
                            }
                        }
                    } else
                    {
                        for(int j1 = 0; j1 < ((EntityPlayer) (entityplayersp)).inventory.getSizeInventory(); j1++)
                        {
                            ItemStack itemstack = ((EntityPlayer) (entityplayersp)).inventory.getStackInSlot(j1);
                            if(itemstack == null || itemstack.itemID != AetherItems.CloudParachuteGold.shiftedIndex || !EntityCloudParachute.entityHasRoomForCloud(minecraft.theWorld, entityplayersp))
                            {
                                continue;
                            }
                            EntityCloudParachute.doCloudSmoke(minecraft.theWorld, entityplayersp);
                            minecraft.theWorld.playSoundAtEntity(entityplayersp, "cloud", 1.0F, 1.0F / (minecraft.theWorld.rand.nextFloat() * 0.1F + 0.95F));
                            if(!minecraft.theWorld.multiplayerWorld)
                            {
                                minecraft.theWorld.spawnEntityInWorld(new EntityCloudParachute(minecraft.theWorld, entityplayersp, true));
                            }
                            itemstack.damageItem(1, entityplayersp);
                            ((EntityPlayer) (entityplayersp)).inventory.setInventorySlotContents(j1, itemstack);
                        }

                    }
                }
            }
            if(getCurrentDimension() == 3)
            {
                boolean flag = ModLoader.getMinecraftInstance().statFileWriter.hasAchievementUnlocked(AetherAchievements.enterAether);
                if(!flag)
                {
                    giveAchievement(AetherAchievements.enterAether, entityplayersp);
                    ((EntityPlayer) (entityplayersp)).inventory.addItemStackToInventory(new ItemStack(AetherItems.LoreBook, 1, 2));
                    ((EntityPlayer) (entityplayersp)).inventory.addItemStackToInventory(new ItemStack(AetherItems.CloudParachuteGold, 1));
                    minecraft.theWorld.playSoundAtEntity(entityplayersp, "random.pop", 0.2F, 1.0F);
                }
            }
        }
        if(world != minecraft.theWorld || minecraft.thePlayer != null && (minecraft.thePlayer.isDead || minecraft.thePlayer.health <= 0))
        {
            world = minecraft.theWorld;
            return true;
        }
        if(world == null)
        {
            return true;
        }
        if(!world.multiplayerWorld && ModLoader.isGUIOpen(null))
        {
            renderHearts();
            renderJumps();
        }
        if(!world.multiplayerWorld && (minecraft.currentScreen instanceof GuiInventory))
        {
            minecraft.displayGuiScreen(new GuiInventoryMoreSlots(minecraft.thePlayer));
        }
        repShieldUpdate(minecraft);
        AetherPoison.tickRender(minecraft);
        renderBossHP();
        float f1 = getPlayer().prevTimeInPortal * 1.2F + (getPlayer().timeInPortal - getPlayer().prevTimeInPortal);
        if(f1 > 0.0F)
        {
            GL11.glEnable(3042 /*GL_BLEND*/);
            ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
            int i = scaledresolution.getScaledWidth();
            int j = scaledresolution.getScaledHeight();
            renderPortalOverlay(f1, i, j);
            GL11.glDisable(3042 /*GL_BLEND*/);
        }
        long l = minecraft.theWorld.getWorldTime();
        if(clock != l)
        {
            AetherItems.tick(minecraft);
            updateCounter++;
            clock = l;
        }
        return true;
    }

    private void renderPortalOverlay(float f, int i, int j)
    {
        if(f < 1.0F)
        {
            f *= f;
            f *= f;
            f = f * 0.8F + 0.2F;
        }
        GL11.glDisable(3008 /*GL_ALPHA_TEST*/);
        GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, mc.renderEngine.getTexture("/aetherBlocks.png"));
        float f1 = (float)(AetherBlocks.Portal.blockIndexInTexture % 16) / 16F;
        float f2 = (float)(AetherBlocks.Portal.blockIndexInTexture / 16) / 16F;
        float f3 = (float)(AetherBlocks.Portal.blockIndexInTexture % 16 + 1) / 16F;
        float f4 = (float)(AetherBlocks.Portal.blockIndexInTexture / 16 + 1) / 16F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, j, -90D, f1, f4);
        tessellator.addVertexWithUV(i, j, -90D, f3, f4);
        tessellator.addVertexWithUV(i, 0.0D, -90D, f3, f2);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90D, f1, f2);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
        GL11.glEnable(3008 /*GL_ALPHA_TEST*/);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public static void giveAchievement(Achievement achievement)
    {
        giveAchievement(achievement, ((EntityPlayer) (ModLoader.getMinecraftInstance().thePlayer)));
    }

    public static void giveAchievement(Achievement achievement, EntityPlayer entityplayer)
    {
        if(ModLoader.getMinecraftInstance().statFileWriter.hasAchievementUnlocked(achievement))
        {
            return;
        } else
        {
            ModLoader.getMinecraftInstance().sndManager.playSoundFX("aether.sound.other.achievement.achievementGen", 1.0F, 1.0F);
            entityplayer.triggerAchievement(achievement);
            return;
        }
    }

    public void repShieldUpdate(Minecraft minecraft)
    {
        World world1 = minecraft.theWorld;
        if(world1 != null && !world1.multiplayerWorld)
        {
            List list = world1.playerEntities;
            if(list != null && list.size() > 0)
            {
                for(int i = 0; i < list.size(); i++)
                {
                    EntityPlayer entityplayer = (EntityPlayer)list.get(i);
                    boolean flag = false;
                    InventoryPlayer inventoryplayer = entityplayer.inventory;
                    ItemStack itemstack = null;
                    if(inventoryplayer.armorInventory.length > 4)
                    {
                        flag = inventoryplayer != null && inventoryplayer.armorInventory[6] != null && inventoryplayer.armorInventory[6].itemID == AetherItems.RepShield.shiftedIndex;
                        itemstack = inventoryplayer.armorInventory[6];
                    }
                    if(!flag || !entityplayer.onGround && (entityplayer.ridingEntity == null || !entityplayer.ridingEntity.onGround) || entityplayer.moveForward != 0.0F || entityplayer.moveStrafing != 0.0F)
                    {
                        continue;
                    }
                    if(minecraft.gameSettings.thirdPersonView != 0 && entityplayer == minecraft.thePlayer)
                    {
                        renderShieldEffect(minecraft);
                    }
                    List list1 = world1.getEntitiesWithinAABBExcludingEntity(entityplayer, entityplayer.boundingBox.expand(4D, 4D, 4D));
                    for(int j = 0; j < list1.size() && itemstack != null && itemstack.getItemDamage() < 500; j++)
                    {
                        Entity entity = (Entity)list1.get(j);
                        boolean flag1 = false;
                        if((entity instanceof EntityProjectileBase) && entity.getDistanceToEntity(entityplayer) < 2.5F && (entity.prevPosX != entity.posX || entity.prevPosY != entity.posY || entity.prevPosZ != entity.posZ))
                        {
                            EntityProjectileBase entityprojectilebase = (EntityProjectileBase)entity;
                            if(entityprojectilebase.shooter == null || entityprojectilebase.shooter != entityplayer)
                            {
                                EntityLiving entityliving = entityprojectilebase.shooter;
                                entityprojectilebase.shooter = entityplayer;
                                flag1 = true;
                                double d;
                                double d2;
                                double d4;
                                if(entityliving != null)
                                {
                                    d = entityprojectilebase.posX - ((Entity) (entityliving)).posX;
                                    d2 = entityprojectilebase.boundingBox.minY - ((Entity) (entityliving)).boundingBox.minY;
                                    d4 = entityprojectilebase.posZ - ((Entity) (entityliving)).posZ;
                                } else
                                {
                                    d = entityplayer.posX - entityprojectilebase.posX;
                                    d2 = entityplayer.posY - entityprojectilebase.posY;
                                    d4 = entityplayer.posZ - entityprojectilebase.posZ;
                                }
                                double d6 = Math.sqrt(d * d + d2 * d2 + d4 * d4);
                                d /= -d6;
                                d2 /= -d6;
                                d4 /= -d6;
                                entityprojectilebase.motionX = d * 0.75D;
                                entityprojectilebase.motionY = d2 * 0.75D + 0.050000000000000003D;
                                entityprojectilebase.motionZ = d4 * 0.75D;
                                entityprojectilebase.setArrowHeading(entityprojectilebase.motionX, entityprojectilebase.motionY, entityprojectilebase.motionZ, 0.8F, 0.5F);
                                world1.playSoundAtEntity(entityprojectilebase, "note.snare", 1.0F, ((entityplayer.rand.nextFloat() - entityplayer.rand.nextFloat()) * 0.4F + 0.8F) * 1.1F);
                                for(int k = 0; k < 12; k++)
                                {
                                    double d8 = -entityprojectilebase.motionX * 0.15000000596046448D + (double)((entityprojectilebase.rand.nextFloat() - 0.5F) * 0.05F);
                                    double d10 = -entityprojectilebase.motionY * 0.15000000596046448D + (double)((entityprojectilebase.rand.nextFloat() - 0.5F) * 0.05F);
                                    double d12 = -entityprojectilebase.motionZ * 0.15000000596046448D + (double)((entityprojectilebase.rand.nextFloat() - 0.5F) * 0.05F);
                                    d8 *= 0.625D;
                                    d10 *= 0.625D;
                                    d12 *= 0.625D;
                                    world1.spawnParticle("flame", entityprojectilebase.posX, entityprojectilebase.posY, entityprojectilebase.posZ, d8, d10, d12);
                                }

                            }
                        } else
                        if((entity instanceof EntityArrow) && entity.getDistanceToEntity(entityplayer) < 2.5F && (entity.prevPosX != entity.posX || entity.prevPosY != entity.posY || entity.prevPosZ != entity.posZ))
                        {
                            EntityArrow entityarrow = (EntityArrow)entity;
                            if(entityarrow.shootingEntity == null || entityarrow.shootingEntity != entityplayer)
                            {
                                Entity entity1 = entityarrow.shootingEntity;
                                entityarrow.shootingEntity = entityplayer;
                                flag1 = true;
                                double d1;
                                double d3;
                                double d5;
                                if(entity1 != null)
                                {
                                    d1 = entityarrow.posX - entity1.posX;
                                    d3 = entityarrow.boundingBox.minY - entity1.boundingBox.minY;
                                    d5 = entityarrow.posZ - entity1.posZ;
                                } else
                                {
                                    d1 = entityplayer.posX - entityarrow.posX;
                                    d3 = entityplayer.posY - entityarrow.posY;
                                    d5 = entityplayer.posZ - entityarrow.posZ;
                                }
                                double d7 = Math.sqrt(d1 * d1 + d3 * d3 + d5 * d5);
                                d1 /= -d7;
                                d3 /= -d7;
                                d5 /= -d7;
                                entityarrow.motionX = d1 * 0.75D;
                                entityarrow.motionY = d3 * 0.75D + 0.14999999999999999D;
                                entityarrow.motionZ = d5 * 0.75D;
                                entityarrow.setArrowHeading(entityarrow.motionX, entityarrow.motionY, entityarrow.motionZ, 0.8F, 0.5F);
                                world1.playSoundAtEntity(entityarrow, "note.snare", 1.0F, ((entityplayer.rand.nextFloat() - entityplayer.rand.nextFloat()) * 0.4F + 0.8F) * 1.1F);
                                for(int l = 0; l < 12; l++)
                                {
                                    double d9 = -entityarrow.motionX * 0.15000000596046448D + (double)((entityarrow.rand.nextFloat() - 0.5F) * 0.05F);
                                    double d11 = -entityarrow.motionY * 0.15000000596046448D + (double)((entityarrow.rand.nextFloat() - 0.5F) * 0.05F);
                                    double d13 = -entityarrow.motionZ * 0.15000000596046448D + (double)((entityarrow.rand.nextFloat() - 0.5F) * 0.05F);
                                    d9 *= 0.625D;
                                    d11 *= 0.625D;
                                    d13 *= 0.625D;
                                    world1.spawnParticle("flame", entityarrow.posX, entityarrow.posY, entityarrow.posZ, d9, d11, d13);
                                }

                            }
                        }
                        if(!flag1 || itemstack == null)
                        {
                            continue;
                        }
                        itemstack.damageItem(1, entityplayer);
                        if(itemstack.getItemDamage() >= 500)
                        {
                            entityplayer.inventory.armorInventory[6] = null;
                        }
                    }

                }

            }
        }
    }

    private void renderShieldEffect(Minecraft minecraft)
    {
        ScaledResolution scaledresolution = new ScaledResolution(minecraft.gameSettings, minecraft.displayWidth, minecraft.displayHeight);
        int i = scaledresolution.getScaledWidth();
        int j = scaledresolution.getScaledHeight();
        GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3008 /*GL_ALPHA_TEST*/);
        GL11.glEnable(2977 /*GL_NORMALIZE*/);
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, minecraft.renderEngine.getTexture("/aether/other/shieldEffect.png"));
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, j, -90D, 0.0D, 1.0D);
        tessellator.addVertexWithUV(i, j, -90D, 1.0D, 1.0D);
        tessellator.addVertexWithUV(i, 0.0D, -90D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
        GL11.glEnable(3008 /*GL_ALPHA_TEST*/);
        GL11.glDisable(2977 /*GL_NORMALIZE*/);
        GL11.glDisable(3042 /*GL_BLEND*/);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private String randomText()
    {
        int i = rand.nextInt(19);
        switch(i)
        {
        case 0: // '\0'
            return "Taming Moas";

        case 1: // '\001'
            return "Hiding Chests";

        case 2: // '\002'
            return "Defying Gravity";

        case 3: // '\003'
            return "Enchanting Darts";

        case 4: // '\004'
            return "Sssssssss.....";

        case 5: // '\005'
            return "Growing Skyroot";

        case 6: // '\006'
            return "Writing Lore";

        case 7: // '\007'
            return "Puffing Sheepuffs";

        case 8: // '\b'
            return "Making Portals";

        case 9: // '\t'
            return "Locking Chests";

        case 10: // '\n'
            return "Making Pigs Fly";

        case 11: // '\013'
            return "Growing Grass";

        case 12: // '\f'
            return "Freezing Icestone";

        case 13: // '\r'
            return "Building Temples";

        case 14: // '\016'
            return "Planting Golden Oaks";

        case 15: // '\017'
            return "Angering Zephyrs";

        case 16: // '\020'
            return "Mimicing Chests";

        case 17: // '\021'
            return "Poisoning Plants";

        case 18: // '\022'
            return "Writing Music";
        }
        return "Loading Aether Mod";
    }

    private void renderHearts()
    {
        Minecraft minecraft = ModLoader.getMinecraftInstance();
        ScaledResolution scaledresolution = new ScaledResolution(minecraft.gameSettings, minecraft.displayWidth, minecraft.displayHeight);
        int i = scaledresolution.getScaledWidth();
        int j = scaledresolution.getScaledHeight();
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, minecraft.renderEngine.getTexture("/gui/icons.png"));
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glBlendFunc(775, 769);
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042 /*GL_BLEND*/);
        boolean flag = (minecraft.thePlayer.heartsLife / 3) % 2 == 1;
        if(minecraft.thePlayer.heartsLife < 10)
        {
            flag = false;
        }
        int k = minecraft.thePlayer.health - 20;
        int l = minecraft.thePlayer.prevHealth - 20;
        rand.setSeed(updateCounter * 0x4c627);
        if(minecraft.playerController.shouldDrawHUD())
        {
            for(int i1 = 0; i1 < getPlayer(minecraft.thePlayer).maxHealth / 2 - 10; i1++)
            {
                int j1 = j - 50;
                if(minecraft.thePlayer.getPlayerArmorValue() > 0)
                {
                    j1 -= 9;
                }
                int k1 = 0;
                if(flag)
                {
                    k1 = 1;
                }
                int l1 = (i / 2 - 91) + i1 * 8;
                if(minecraft.thePlayer.health <= 4)
                {
                    j1 += rand.nextInt(2);
                }
                drawTexturedModalRect(l1, j1, 16 + k1 * 9, 0, 9, 9);
                if(flag)
                {
                    if(i1 * 2 + 1 < l)
                    {
                        drawTexturedModalRect(l1, j1, 70, 0, 9, 9);
                    }
                    if(i1 * 2 + 1 == l)
                    {
                        drawTexturedModalRect(l1, j1, 79, 0, 9, 9);
                    }
                }
                if(i1 * 2 + 1 < k)
                {
                    drawTexturedModalRect(l1, j1, 52, 0, 9, 9);
                }
                if(i1 * 2 + 1 == k)
                {
                    drawTexturedModalRect(l1, j1, 61, 0, 9, 9);
                }
            }

        }
        GL11.glDisable(3042 /*GL_BLEND*/);
    }

    private void renderJumps()
    {
        Minecraft minecraft = ModLoader.getMinecraftInstance();
        if(!(minecraft.thePlayer.ridingEntity instanceof EntityMoa))
        {
            return;
        }
        if(minecraft.playerController.shouldDrawHUD() && minecraft.inGameHasFocus)
        {
            ScaledResolution scaledresolution = new ScaledResolution(minecraft.gameSettings, minecraft.displayWidth, minecraft.displayHeight);
            EntityMoa entitymoa = (EntityMoa)minecraft.thePlayer.ridingEntity;
            int i = scaledresolution.getScaledWidth();
            int j = scaledresolution.getScaledHeight();
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, minecraft.renderEngine.getTexture("/aether/gui/jumps.png"));
            GL11.glEnable(3042 /*GL_BLEND*/);
            GL11.glBlendFunc(775, 769);
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
            GL11.glDisable(3042 /*GL_BLEND*/);
            for(int k = 0; k < entitymoa.colour.jumps; k++)
            {
                int l = j - 44;
                int i1 = i / 2 + 1 + 9 * (k + 1);
                if(k < entitymoa.jrem)
                {
                    drawTexturedModalRect(i1, l, 0, 0, 9, 11);
                } else
                {
                    drawTexturedModalRect(i1, l, 10, 0, 9, 11);
                }
            }

        }
        GL11.glDisable(3042 /*GL_BLEND*/);
    }

    private void renderBossHP()
    {
        if(currentBoss != null)
        {
            Minecraft minecraft = ModLoader.getMinecraftInstance();
            ScaledResolution scaledresolution = new ScaledResolution(minecraft.gameSettings, minecraft.displayWidth, minecraft.displayHeight);
            int i = scaledresolution.getScaledWidth();
            int j = scaledresolution.getScaledHeight();
            String s = currentBoss.getBossTitle();
            minecraft.fontRenderer.drawStringWithShadow(s, i / 2 - minecraft.fontRenderer.getStringWidth(s) / 2, 2, -1);
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, minecraft.renderEngine.getTexture("/aether/gui/bossHPBar.png"));
            GL11.glEnable(3042 /*GL_BLEND*/);
            GL11.glBlendFunc(775, 769);
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
            GL11.glDisable(3042 /*GL_BLEND*/);
            drawTexturedModalRect(i / 2 - 128, 12, 0, 16, 256, 32);
            int k = (int)(((float)currentBoss.getBossHP() / (float)currentBoss.getBossMaxHP()) * 256F);
            drawTexturedModalRect(i / 2 - 128, 12, 0, 0, k, 16);
        }
    }

    public void drawTexturedModalRect(int i, int j, int k, int l, int i1, int j1)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(i + 0, j + j1, zLevel, (float)(k + 0) * f, (float)(l + j1) * f1);
        tessellator.addVertexWithUV(i + i1, j + j1, zLevel, (float)(k + i1) * f, (float)(l + j1) * f1);
        tessellator.addVertexWithUV(i + i1, j + 0, zLevel, (float)(k + i1) * f, (float)(l + 0) * f1);
        tessellator.addVertexWithUV(i + 0, j + 0, zLevel, (float)(k + 0) * f, (float)(l + 0) * f1);
        tessellator.draw();
    }

    public void AddRenderer(Map map)
    {
        AetherBlocks.AddRenderer(map);
        AetherItems.AddRenderer(map);
        AetherMobs.AddRenderer(map);
        AetherPoison.AddRenderer(map);
        map.put(net.minecraft.src.EntityPlayer.class, new RenderPlayerAether());
    }

    public void TakenFromCrafting(EntityPlayer entityplayer, ItemStack itemstack)
    {
        AetherItems.takenCrafting(entityplayer, itemstack);
    }

    public static boolean equippedSkyrootSword()
    {
        ItemStack itemstack = ModLoader.getMinecraftInstance().thePlayer.inventory.getCurrentItem();
        return itemstack != null && itemstack.itemID == AetherItems.SwordSkyroot.shiftedIndex;
    }

    public static boolean equippedSkyrootPick()
    {
        ItemStack itemstack = ModLoader.getMinecraftInstance().thePlayer.inventory.getCurrentItem();
        return itemstack != null && itemstack.itemID == AetherItems.PickSkyroot.shiftedIndex;
    }

    public static boolean equippedSkyrootShovel()
    {
        ItemStack itemstack = ModLoader.getMinecraftInstance().thePlayer.inventory.getCurrentItem();
        return itemstack != null && itemstack.itemID == AetherItems.ShovelSkyroot.shiftedIndex;
    }

    public static boolean equippedSkyrootAxe()
    {
        ItemStack itemstack = ModLoader.getMinecraftInstance().thePlayer.inventory.getCurrentItem();
        return itemstack != null && itemstack.itemID == AetherItems.AxeSkyroot.shiftedIndex;
    }

    public static int getCurrentDimension()
    {
        EntityPlayerSP entityplayersp = ModLoader.getMinecraftInstance().thePlayer;
        if(entityplayersp == null)
        {
            return 0;
        } else
        {
            return ((EntityPlayer) (entityplayersp)).dimension;
        }
    }

    public String getVersion()
    {
        return "MC 1.0.0 Version 1.04";
    }

    public static PlayerBaseAether getPlayer()
    {
        return getPlayer(((EntityPlayer) (ModLoader.getMinecraftInstance().thePlayer)));
    }

    public static PlayerBaseAether getPlayer(EntityPlayer entityplayer)
    {
        return Player;
    }

    public boolean iBlockMatches(World world1, int i, int j, int k, int l)
    {
        if(getCurrentDimension() == 3)
        {
            if(l == Block.torchWood.blockID)
            {
                return true;
            }
            if(l == Block.fire.blockID)
            {
                return true;
            }
            if(l == Block.netherrack.blockID)
            {
                return true;
            }
            if(l == Block.slowSand.blockID)
            {
                return true;
            }
            if(l == Block.lavaMoving.blockID || l == Block.lavaStill.blockID)
            {
                return true;
            }
            if(l == Block.portal.blockID)
            {
                return true;
            }
            if(l == Block.bed.blockID)
            {
                return true;
            }
        } else
        if(getCurrentDimension() < 0)
        {
            if(l == AetherBlocks.Portal.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.Dirt.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.Grass.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.Aercloud.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.AmbrosiumOre.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.AmbrosiumTorch.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.DungeonStone.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.EnchantedGravitite.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.GoldenOakLeaves.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.GoldenOakSapling.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.GravititeOre.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.Holystone.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.Icestone.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.LightDungeonStone.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.LockedDungeonStone.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.LockedLightDungeonStone.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.ChestMimic.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.Pillar.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.Quicksoil.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.SkyrootLeaves.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.Plank.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.SkyrootSapling.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.Log.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.Trap.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.TreasureChest.blockID)
            {
                return true;
            }
            if(l == AetherBlocks.ZaniteOre.blockID)
            {
                return true;
            }
        }
        return l == Block.waterMoving.blockID || l == Block.waterStill.blockID;
    }

    public int iBlockGet(World world1, int i, int j, int k, int l)
    {
        EntityPlayerSP entityplayersp = ModLoader.getMinecraftInstance().thePlayer;
        if(world != null)
        {
            if(l == Block.bed.blockID)
            {
                int i1 = MathHelper.floor_double((double)((((EntityPlayer) (entityplayersp)).rotationYaw * 4F) / 360F) + 0.5D) & 3;
                byte byte0 = 0;
                byte byte1 = 0;
                if(i1 == 0)
                {
                    byte1 = 1;
                }
                if(i1 == 1)
                {
                    byte0 = -1;
                }
                if(i1 == 2)
                {
                    byte1 = -1;
                }
                if(i1 == 3)
                {
                    byte0 = 1;
                }
                world1.setBlockAndMetadataWithNotify(i + byte0, j, k + byte1, AetherBlocks.Bed.blockID, i1 + 8);
                return AetherBlocks.Bed.blockID;
            }
            if(l == Block.waterMoving.blockID || l == Block.waterStill.blockID)
            {
                if(world.getBlockId(i, j - 1, k) == Block.glowStone.blockID && ((BlockAetherPortal)AetherBlocks.Portal).tryToCreatePortal(world, i, j, k))
                {
                    return AetherBlocks.Portal.blockID;
                }
                if(getCurrentDimension() != -1)
                {
                    return l;
                }
            }
            Random random = new Random();
            for(int j1 = 0; j1 < 10; j1++)
            {
                world.spawnParticle("smoke", (double)i + 0.5D + random.nextGaussian() * 0.10000000000000001D, (double)j + 0.5D + random.nextGaussian() * 0.10000000000000001D, (double)k + 0.5D + random.nextGaussian() * 0.01D, random.nextGaussian() * 0.01D, random.nextGaussian() * 0.01D, random.nextGaussian() * 0.10000000000000001D);
            }

            if(l == Block.lavaMoving.blockID || l == Block.lavaStill.blockID)
            {
                return AetherBlocks.Aerogel.blockID;
            }
            if(getCurrentDimension() < 0 && (l == Block.waterMoving.blockID || l == Block.waterStill.blockID))
            {
                return Block.cobblestone.blockID;
            } else
            {
                return 0;
            }
        } else
        {
            return 0;
        }
    }

    public void iAfterIntercept(World world1, int i, int j, int k, int l)
    {
    }

}
