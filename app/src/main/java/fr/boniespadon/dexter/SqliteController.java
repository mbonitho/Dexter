package fr.boniespadon.dexter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Mathieu on 03/08/2015.
 *
 * MB : Contrôleur SQL : initialise les données de la base SQLite
 * et fournit les méthodes de récupération des Pokémon
 */
public class SqliteController extends SQLiteOpenHelper {

    public SqliteController(Context applicationcontext) {
        super(applicationcontext, "androidsqlite.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creation de la table des Pokémon
        String query;
        query = "CREATE TABLE pokemon ( id INTEGER PRIMARY KEY, name TEXT, description TEXT, imgName TEXT, isFav INTEGER)";
        db.execSQL(query);
        Log.d("dexter", "Table Pokemon Creee dans la BDD");

        //Insertion des donnees
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Bulbizarre', 'Bulbizarre passe son temps à faire la sieste sous le soleil. Il y a une graine sur son dos. Il absorbe les rayons du soleil pour faire doucement pousser la graine. ', 'pkmn_001', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Herbizarre', 'Un bourgeon a poussé sur le dos de ce Pokémon. Pour en supporter le poids, Herbizarre a dû se muscler les pattes. Lorsqu''il commence à se prélasser au soleil, ça signifie que son bourgeon va éclore, donnant naissance à une fleur. ', 'pkmn_002', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Florizarre', 'Une belle fleur se trouve sur le dos de Florizarre. Elle prend une couleur vive lorsqu''elle est bien nourrie et bien ensoleillée. Le parfum de cette fleur peut apaiser les gens. ', 'pkmn_003', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Salamèche', 'La flamme qui brûle au bout de sa queue indique l''humeur de ce Pokémon. Elle vacille lorsque Salamèche est content. En revanche, lorsqu''il s''énerve, la flamme prend de l''importance et brûle plus ardemment. ', 'pkmn_004', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Reptincel', 'Reptincel lacère ses ennemis sans pitié grâce à ses griffes acérées. S''il rencontre un ennemi puissant, il devient agressif et la flamme au bout de sa queue s''embrase et prend une couleur bleu clair.', 'pkmn_005', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Dracaufeu', 'Dracaufeu parcourt les cieux pour trouver des adversaires à sa mesure. Il crache de puissantes flammes capables de faire fondre n''importe quoi. Mais il ne dirige jamais son souffle destructeur vers un ennemi plus faible. ', 'pkmn_006', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Carapuce', 'La carapace de Carapuce ne sert pas qu''à le protéger. La forme ronde de sa carapace et ses rainures lui permettent d''améliorer son hydrodynamisme. Ce Pokémon nage extrêmement vite.', 'pkmn_007', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Carabaffe', 'Carabaffe a une large queue recouverte d''une épaisse fourrure. Elle devient de plus en plus foncée avec l''âge. Les éraflures sur la carapace de ce Pokémon témoignent de son expérience au combat.', 'pkmn_008', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Tortank', 'Tortank dispose de canons à eau émergeant de sa carapace. Ils sont très précis et peuvent envoyer des balles d''eau capables de faire mouche sur une cible située à plus de 50 m. ', 'pkmn_009', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Chenipan', 'Chenipan a un appétit d''ogre. Il peut engloutir des feuilles plus grosses que lui. Les antennes de ce Pokémon dégagent une odeur particulièrement entêtante. ', 'pkmn_010', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Chrysacier', 'La carapace protégeant ce Pokémon est dure comme du métal. Chrysacier ne bouge pas beaucoup. Il reste immobile pour préparer les organes à l''intérieur de sa carapace en vue d''une évolution future.', 'pkmn_011', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Papilusion', 'Papilusion est très doué pour repérer le délicieux nectar qu''il butine dans les fleurs. Il peut détecter, extraire et transporter le nectar de fleurs situées à plus de 10 km de son nid. ', 'pkmn_012', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Aspicot', 'L''odorat d''Aspicot est extrêmement développé. Il lui suffit de renifler ses feuilles préférées avec son gros appendice nasal pour les reconnaître entre mille.', 'pkmn_013', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Coconfort', 'Coconfort est la plupart du temps immobile et reste accroché à un arbre. Cependant, intérieurement, il est très actif, car il se prépare pour sa prochaine évolution. En touchant sa carapace, on peut sentir sa chaleur.', 'pkmn_014', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Dardargnan', 'Dardargnan est extrêmement possessif. Il vaut mieux ne pas toucher son nid si on veut éviter d''avoir des ennuis. Lorsqu''ils sont en colère, ces Pokémon attaquent en masse.', 'pkmn_015', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Roucool', 'Roucool a un excellent sens de l''orientation. Il est capable de retrouver son nid sans jamais se tromper, même s''il est très loin de chez lui et dans un environnement qu''il ne connaît pas. ', 'pkmn_016', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Roucoups', 'Roucoups utilise une vaste surface pour son territoire. Ce Pokémon surveille régulièrement son espace aérien. Si quelqu''un pénètre sur son territoire, il corrige l''ennemi sans pitié d''un coup de ses terribles serres. ', 'pkmn_017', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Roucarnage', 'Ce Pokémon est doté d''un plumage magnifique et luisant. Bien des Dresseurs sont captivés par la beauté fatale de sa huppe et décident de choisir Roucarnage comme leur Pokémon favori.', 'pkmn_018', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Rattata', 'Rattata est extrêmement prudent. Même lorsqu''il est endormi, il fait pivoter ses oreilles pour écouter autour de lui. En ce qui concerne son habitat, il n''est vraiment pas difficile. Il peut faire son nid n''importe où.', 'pkmn_019', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Rattatac', 'Les crocs robustes de Rattatac poussent constamment. Pour éviter qu''ils raclent le sol, il se fait les dents sur des cailloux ou des troncs d''arbre. Il lui arrive même de ronger les murs des maisons. ', 'pkmn_020', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Piafabec', 'Piafabec crie tellement fort qu''il peut être entendu à 1 km de distance. Ces Pokémon se préviennent d''un danger en entonnant une mélopée très aiguë, qu''ils se renvoient les uns les autres, comme un écho. ', 'pkmn_021', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Rapasdepic', 'On reconnaît un Rapasdepic à son long cou et à son bec allongé. Ces attributs lui permettent d''attraper facilement ses proies dans la terre ou dans l''eau. Il bouge son bec long et fin avec une grande agilité. ', 'pkmn_022', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Abo', 'Abo s''enroule en spirale pour dormir. Sa tête reste relevée de telle sorte que cette position lui permette de réagir rapidement si une menace survenait.', 'pkmn_023', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Arbok', 'Ce Pokémon doté d''une force extraordinaire peut étrangler ses proies avec son corps. Il peut même écraser des tonneaux métalliques. Une fois sous l''étreinte d''Arbok, il est impossible de lui échapper. ', 'pkmn_024', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Pikachu', 'Chaque fois que Pikachu découvre quelque chose de nouveau, il envoie un arc électrique. Lorsqu''on tombe sur une Baie carbonisée, ça signifie sans doute qu''un de ces Pokémon a envoyé une charge trop forte.', 'pkmn_025', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Raichu', 'Si ses joues contiennent trop d''électricité, Raichu plante sa queue dans le sol pour se décharger. On trouve des parcelles de terre brûlée à proximité du nid de ce Pokémon. ', 'pkmn_026', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Sabelette', 'Le corps de Sabelette lui permet d''économiser l''eau qu''il absorbe, afin de survivre longtemps dans le désert. Ce Pokémon s''enroule sur lui-même pour se protéger de ses ennemis.', 'pkmn_027', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Sablaireau', 'Le corps de Sablaireau est recouvert de pointes très dures, qui sont des extensions de sa peau. Une fois par an, ce Pokémon mue et les vieilles pointes tombent, remplacées par de nouvelles.', 'pkmn_028', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Nidoran femelle', 'Nidoran femelle est couvert de pointes qui sécrètent un poison puissant. On pense que ce petit Pokémon a développé ces pointes pour se défendre. Lorsqu''il est en colère, une horrible toxine sort de sa corne.', 'pkmn_029', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Nidorina', 'Lorsqu''un Nidorina est avec ses amis ou sa famille, il replie ses pointes pour ne pas blesser ses proches. Ce Pokémon devient vite nerveux lorsqu''il est séparé de son groupe.', 'pkmn_030', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Nidoqueen', 'Le corps de Nidoqueen est protégé par des écailles extrêmement dures. Il aime envoyer ses ennemis voler en leur fonçant dessus. Ce Pokémon utilise toute sa puissance lorsqu''il protège ses petits. ', 'pkmn_031', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Nidoran mâle', 'Nidoran mâle a développé des muscles pour bouger ses oreilles. Ainsi, il peut les orienter à sa guise. Ce Pokémon peut entendre le plus discret des bruits. ', 'pkmn_032', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Nidorino', 'Nidorino dispose d''une corne plus dure que du diamant. S''il sent une présence hostile, toutes les pointes de son dos se hérissent d''un coup, puis il défie son ennemi. ', 'pkmn_033', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Nidoking', 'L''épaisse queue de Nidoking est d''une puissance incroyable. En un seul coup, il peut renverser une tour métallique. Lorsque ce Pokémon se déchaîne, plus rien ne peut l''arrêter. ', 'pkmn_034', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Mélofée', 'Les nuits de pleine lune, des groupes de ces Pokémon sortent jouer. Lorsque l''aube commence à poindre, les Mélofée fatigués rentrent dans leur retraite montagneuse et vont dormir, blottis les uns contre les autres. ', 'pkmn_035', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Mélodelfe', 'Les Mélodelfe se déplacent en sautant doucement, comme s''ils volaient. Leur démarche légère leur permet même de marcher sur l''eau. On raconte qu''ils se promènent sur les lacs, les soirs où la lune est claire.', 'pkmn_036', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Goupix', 'À sa naissance, Goupix a une queue blanche. Cette queue se divise en six si le Pokémon reçoit de l''amitié de la part de son Dresseur. Les six queues sont courbées et magnifiques.', 'pkmn_037', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Feunard', 'Feunard peut envoyer un inquiétant rayon avec ses yeux rouge vif pour prendre le contrôle de l''esprit de son ennemi. On raconte que ce Pokémon peut vivre 1 000 ans.', 'pkmn_038', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Rondoudou', 'Rondoudou utilise ses cordes vocales pour ajuster librement la longueur d''onde de sa voix. Cela permet à ce Pokémon de chanter en utilisant une longueur d''onde qui endort ses ennemis.', 'pkmn_039', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Grodoudou', 'Grodoudou a des yeux immenses et écarquillés. La surface de ses yeux est couverte d''une fine couche de larmes. Si de la poussière est projetée dans les yeux de ce Pokémon, elle est rapidement évacuée.', 'pkmn_040', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Nosferapti', 'Nosferapti reste calme et immobile dans un coin sombre pendant la journée. En effet, une exposition trop longue à la lumière du soleil lui brûle légèrement la peau. ', 'pkmn_041', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Nosferalto', 'Nosferalto adore boire le sang des créatures vivantes. Il est particulièrement actif pendant les nuits noires. Ce Pokémon se balade dans les cieux étoilés, à la recherche de sang frais.', 'pkmn_042', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Mystherbe', 'Pendant la journée, Mystherbe s''enterre dans le sol pour absorber avec son corps tout entier les nutriments présents dans la terre. Plus le sol est fertile, plus ses feuilles sont brillantes.', 'pkmn_043', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Ortide', 'La plupart du temps, Ortide dégage un parfum immonde du pistil de sa fleur. Lorsqu''il se sent en danger, la puanteur est encore pire. Lorsque ce Pokémon se sent bien et en sécurité, il ne dégage aucune odeur nauséabonde.', 'pkmn_044', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Rafflesia', 'Le pollen toxique de Rafflesia déclenche d''affreuses réactions allergiques. C''est pourquoi il est conseillé de ne jamais s''approcher des jolies fleurs trouvées dans la jungle, même lorsqu''elles sont magnifiques. ', 'pkmn_045', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Paras', 'Paras accueille des champignons parasites appelés tochukaso qui poussent sur son dos. Ils grandissent grâce aux nutriments trouvés sur le dos de ce Pokémon Insecte. Ils peuvent rallonger l''espérance de vie. ', 'pkmn_046', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Parasect', 'On sait que les Parasect vivent en groupe dans les grands arbres et se nourrissent des nutriments contenus dans le tronc et les racines. Lorsqu''un arbre infesté meurt, ils se précipitent vers le prochain.', 'pkmn_047', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Mimitoss', 'On raconte que Mimitoss a évolué avec une fourrure de poils fins et drus qui protège son corps tout entier. Il est doté de grands yeux capables de repérer ses proies, même minuscules.', 'pkmn_048', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Aéromite', 'Aéromite est un Pokémon nocturne, il ne sort donc que la nuit. Ses proies préférées sont les petits insectes qui se rassemblent autour des réverbères, attirés par la lumière.', 'pkmn_049', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Taupiqueur', 'Les Taupiqueur sont élevés dans la plupart des fermes. En effet, lorsque ce Pokémon creuse quelque part, le sol est comme labouré, prêt à recevoir les semences. On peut alors y planter de délicieux légumes.', 'pkmn_050', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Triopikeur', 'Les Triopikeur sont en fait des triplés qui ont émergé du même corps. C''est pourquoi chaque triplé pense exactement comme les deux autres. Ils creusent inlassablement, dans une coopération parfaite.', 'pkmn_051', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Miaouss', 'Miaouss peut rentrer ses griffes dans ses pattes pour rôder gracieusement sans laisser de traces. Étrangement, ce Pokémon raffole des pièces d''or qui brillent à la lumière. ', 'pkmn_052', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Persian', 'Persian a six grosses vibrisses qui lui donnent un air costaud et lui permettent de sentir les mouvements de l''air pour savoir ce qui se trouve à proximité. Il devient docile lorsqu''on l''attrape par les moustaches.', 'pkmn_053', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Psykokwak', 'Psykokwak utilise un mystérieux pouvoir. Ce Pokémon peut générer des ondes cérébrales normalement observées chez les dormeurs. Cette découverte a lancé une polémique dans le milieu universitaire.', 'pkmn_054', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Akwakwak', 'Les pattes avant et arrière palmées et le corps aérodynamique d''Akwakwak lui donnent une vitesse effrayante. Ce Pokémon est bien plus rapide que les plus grands champions de natation. ', 'pkmn_055', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Férosinge', 'Lorsque Férosinge commence à trembler et que sa respiration devient haletante, cela signifie qu''il est en colère. En outre, la moutarde lui monte au nez tellement vite qu''il est presque impossible d''échapper à sa colère. ', 'pkmn_056', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Colossinge', 'Lorsque Colossinge devient furieux, sa circulation sanguine s''accélère. Du coup, ses muscles sont encore plus puissants. En revanche, il devient bien moins intelligent. ', 'pkmn_057', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Caninos', 'Caninos a un odorat très développé. Ce Pokémon n''oublie jamais un parfum, quel qu''il soit. Il utilise son puissant sens olfactif pour deviner les émotions des autres créatures vivantes.', 'pkmn_058', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Arcanin', 'Arcanin est célèbre pour son extraordinaire vitesse. On le dit capable de parcourir plus de 10 000 km en 24 h. Le feu qui fait rage à l''intérieur du corps de ce Pokémon est la source de son pouvoir.', 'pkmn_059', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Ptitard', 'Ptitard a une peau très fine. On peut même voir les entrailles en spirale de ce Pokémon à travers sa peau. Malgré sa finesse, cette peau est aussi très élastique. Même les crocs les plus acérés rebondissent dessus.', 'pkmn_060', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Têtarte', 'La peau de Têtarte est toujours maintenue humide par un liquide huileux. Grâce à cette protection graisseuse, il peut facilement se glisser hors de l''étreinte de n''importe quel ennemi.', 'pkmn_061', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Tartard', 'Les muscles solides et surdéveloppés de Tartard ne se fatiguent jamais, quels que soient les efforts qu''il produit. Ce Pokémon est tellement endurant qu''il peut traverser un océan à la nage avec une étonnante facilité.', 'pkmn_062', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Abra', 'Abra dort dix-huit heures par jour. Pourtant, il peut sentir la présence de ses ennemis, même endormi. Dans ce genre de situation, ce Pokémon se téléporte en lieu sûr. ', 'pkmn_063', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Kadabra', 'Kadabra émet une onde alpha si particulière qu''elle vous donne mal à la tête. Seuls les gens avec un psychisme puissant peuvent espérer devenir Dresseur de ce Pokémon. ', 'pkmn_064', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Alakazam', 'Le cerveau d''Alakazam grossit sans arrêt, si bien que sa tête devient trop lourde pour son cou. Ce Pokémon maintient sa tête relevée grâce à son pouvoir télékinétique.', 'pkmn_065', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Machoc', 'Les muscles de Machoc sont spéciaux. Quels que soient les efforts qu''il produit, il n''a jamais de courbature. Ce Pokémon est assez puissant pour lancer une centaine d''hommes adultes.', 'pkmn_066', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Machopeur', 'Les muscles toniques de Machopeur sont durs comme de l''acier. Ce Pokémon est si fort qu''il peut facilement soulever un sumo avec un seul doigt. ', 'pkmn_067', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Mackogneur', 'Mackogneur est capable de déplacer n''importe quelle masse. Cependant, ses bras s''emmêlent dès qu''il essaie de réaliser un travail délicat ou minutieux. Ce Pokémon a tendance à cogner d''abord et à réfléchir ensuite. ', 'pkmn_068', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Chétiflor', 'Le corps long et flexible de Chétiflor lui permet de se tordre et d''osciller pour éviter tout type d''attaque, même les plus puissantes. Ce Pokémon crache un fluide corrosif qui peut même dissoudre le fer.', 'pkmn_069', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Boustiflor', 'Boustiflor est doté d''un gros crochet. La nuit, ce Pokémon s''accroche à une branche pour s''endormir. Quand il a un sommeil agité, il se réveille par terre. ', 'pkmn_070', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Empiflor', 'Empiflor est doté d''une longue liane qui part de sa tête. Cette liane se balance et remue comme un animal pour attirer ses proies. Lorsque l''une d''elles s''approche un peu trop près, ce Pokémon l''avale entièrement.', 'pkmn_071', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Tentacool', 'Le corps de Tentacool est principalement aqueux. Si on le retire de l''eau, il se déshydrate complètement. Si cela arrive, il suffit de le replonger dans un liquide pour qu''il reprenne sa forme normale.', 'pkmn_072', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Tentacruel', 'Tentacruel a deux gros globes sur la tête. Les globes s''illuminent lorsqu''il va envoyer un violent rayon d''ultrasons. Lorsque ce Pokémon se déchaîne, il crée d''énormes vagues autour de lui. ', 'pkmn_073', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Racaillou', 'Lorsqu''un Racaillou prend de l''âge, ses bords s''ébrèchent et s''usent, ce qui lui donne une apparence plus ronde. Cependant, le cœur de ce Pokémon reste dur, rocailleux et rugueux. ', 'pkmn_074', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Gravalanch', 'Gravalanch grandit en se nourrissant de cailloux. Apparemment, il a une préférence pour les cailloux recouverts de mousse. En moyenne, il mange une tonne de rochers par jour.', 'pkmn_075', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Grolem', 'Grolem vit à la montagne. Lorsqu''il y a un tremblement de terre, ces Pokémon roulent en groupe vers les contreforts montagneux.', 'pkmn_076', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Ponyta', 'À sa naissance, Ponyta est très faible. Il peut à peine tenir debout. Ce Pokémon se muscle en trébuchant et en tombant, lorsqu''il essaie de suivre ses parents. ', 'pkmn_077', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Galopa', 'On voit souvent Galopa trotter dans les champs et les plaines. Cependant, lorsque ce Pokémon s''en donne la peine, il peut galoper à plus de 240 km/h et sa crinière flamboyante s''embrase. ', 'pkmn_078', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Ramoloss', 'Ramoloss trempe sa queue dans l''eau au bord des rivières pour attraper ses proies. Cependant, ce Pokémon oublie souvent ce qu''il fait là et passe des jours entiers à traîner au bord de l''eau. ', 'pkmn_079', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Flagadoss', 'Flagadoss a un Kokiyas solidement attaché à sa queue. Du coup, il ne peut plus l''utiliser pour pêcher. Flagadoss est donc obligé, à contrecœur, de nager pour attraper ses proies.', 'pkmn_080', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Magnéti', 'Magnéti s''attache aux lignes à haute tension pour se charger en électricité. Si une maison a une panne de courant, il est conseillé de vérifier les fusibles car on trouve parfois ces Pokémon amassés sur la boîte à fusibles.', 'pkmn_081', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Magnéton', 'Magnéton émet un puissant champ magnétique qui neutralise les appareils mécaniques. Lorsque ces Pokémon débarquent en masse, les villes sonnent l''alarme et préviennent les habitants.', 'pkmn_082', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Canarticho', 'On voit souvent des Canarticho avec une tige, récupérée sur une plante quelconque. Apparemment, ils peuvent distinguer les bonnes des mauvaises. On a vu ces Pokémon se battre pour des histoires de tiges.', 'pkmn_083', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Doduo', 'Les deux têtes de Doduo ne dorment jamais en même temps. Elles se reposent à tour de rôle pour que l''une puisse monter la garde pendant que l''autre dort.', 'pkmn_084', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Dodrio', 'Il faut se méfier lorsque les trois têtes de Dodrio regardent dans des directions différentes. Cela signifie qu''il est sur ses gardes. Si c''est le cas, il vaut mieux ne pas s''approcher de ce Pokémon, il pourrait décider d''attaquer.', 'pkmn_085', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Otaria', 'Otaria chasse ses proies dans l''eau gelée, sous la couche de glace. Lorsqu''il cherche à respirer, il perce un trou en frappant la glace avec la partie saillante de sa tête.', 'pkmn_086', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Lamantine', 'Lamantine adore piquer un roupillon à même la glace. Il y a très longtemps, un marin ayant aperçu ce Pokémon dormant sur un glacier a cru voir une sirène.', 'pkmn_087', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Tadmorv', 'Le corps boueux et gélatineux de Tadmorv peut s''enfoncer dans n''importe quelle ouverture, même la plus petite. Ce Pokémon se promène dans les tuyaux des égouts pour boire de l''eau croupie.', 'pkmn_088', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Grotadmorv', 'Un fluide nauséabond suinte du corps de Grotadmorv, agressant les narines de ses ennemis. Une seule goutte de ce fluide suffit à faire croupir un bassin d''eau propre.', 'pkmn_089', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Kokiyas', 'La nuit, ce Pokémon utilise sa grande langue pour creuser un trou dans le sable des fonds marins afin d''y dormir. Une fois endormi, Kokiyas referme sa coquille, mais laisse sa langue dépasser.', 'pkmn_090', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Crustabri', 'Crustabri est capable de se déplacer dans les fonds marins en avalant de l''eau et en la rejetant vers l''arrière. Ce Pokémon envoie des pointes en utilisant la même méthode.', 'pkmn_091', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Fantominus', 'Fantominus est principalement constitué de matière gazeuse. Lorsqu''il est exposé au vent, son corps gazeux se disperse et diminue. Des groupes de ce Pokémon se rassemblent sous les auvents des maisons pour se protéger.', 'pkmn_092', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Spectrum', 'Spectrum est un Pokémon dangereux. Si l''un d''entre eux fait signe d''approcher, il ne faut jamais l''écouter. Ce Pokémon risque de sortir sa langue pour essayer de voler votre vie.', 'pkmn_093', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Ectoplasma', 'Parfois, pendant les nuits noires, une ombre projetée par un réverbère peut tout à coup vous dépasser. Il s''agit d''un Ectoplasma qui court, en se faisant passer pour l''ombre de quelqu''un d''autre.', 'pkmn_094', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Onix', 'Onix a dans le cerveau un aimant qui lui sert de boussole. Il permet à ce Pokémon de ne pas se perdre pendant qu''il creuse. En prenant de l''âge, son corps s''arrondit et se polit.', 'pkmn_095', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Soporifik', 'Lorsque les enfants ont le nez qui les démange en dormant, c''est sans doute parce que ce Pokémon se tient au-dessus de leur oreiller, afin d''essayer de manger leurs rêves par leurs narines.', 'pkmn_096', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Hypnomade', 'Hypnomade tient un pendule dans sa main. Le mouvement de balancier et les reflets brillants du pendule hypnotisent profondément son ennemi. Lorsque ce Pokémon cherche ses proies, il nettoie son pendule.', 'pkmn_097', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Krabby', 'Krabby vit sur les plages, enterré dans le sable. Sur les plages où on trouve peu de nourriture, on peut voir ces Pokémon se disputer pour défendre leur territoire.', 'pkmn_098', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Krabboss', 'Krabboss est doté d''une pince gigantesque, surdimensionnée. Il l''agite en l''air pour communiquer avec ses semblables. En revanche, sa pince est tellement lourde que ce Pokémon se fatigue très vite.', 'pkmn_099', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Voltorbe', 'La première fois qu''on a vu Voltorbe, c''était dans une usine qui fabrique des Poké Balls. Personne n''a jamais pu expliquer le lien entre cet événement et la ressemblance frappante de ce Pokémon avec une Poké Ball. ', 'pkmn_100', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Électrode', 'Électrode mange l''électricité qui se trouve dans l''atmosphère. Les jours d''orage, on peut voir ce Pokémon exploser sans arrêt parce qu''il a avalé trop d''électricité.', 'pkmn_101', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Noeunoeuf', 'Ce Pokémon est constitué de six œufs formant une grappe serrée. Ces six œufs s''attirent mutuellement et pivotent. Quand des fissures apparaissent sur les coquilles, ça signifie que Noeunoeuf est sur le point d''évoluer.', 'pkmn_102', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Noadkoko', 'Noadkoko vient des tropiques. À force de vivre sous un soleil ardent, ses têtes ont rapidement grandi. On raconte que lorsque ses têtes tombent, elles se rassemblent et forment un Noeunoeuf.', 'pkmn_103', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Osselait', 'La maman d''Osselait lui manque terriblement et il ne la reverra jamais. La lune le fait pleurer, car elle lui rappelle sa mère. Les taches sur le crâne que porte ce Pokémon sont les marques de ses larmes.', 'pkmn_104', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Ossatueur', 'Ossatueur est la forme évoluée d''Osselait. Il a surmonté le chagrin causé par la perte de sa maman et s''est endurci. Le tempérament décidé et entier de ce Pokémon le rend très difficile à amadouer. ', 'pkmn_105', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Kicklee', 'Les jambes de Kicklee peuvent se contracter et s''étirer à volonté. Grâce à ces jambes à ressort, il terrasse ses ennemis en les rouant de coups de pied. Après les combats, il masse ses jambes pour éviter de sentir la fatigue.', 'pkmn_106', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Tygnon', 'On raconte que Tygnon dispose de l''état d''esprit d''un boxeur qui s''entraîne pour le championnat du monde. Ce Pokémon est doté d''une ténacité à toute épreuve et n''abandonne jamais face à l''adversité.', 'pkmn_107', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Excelangue', 'Chaque fois qu''Excelangue découvre quelque chose de nouveau, il le lèche. Sa mémoire est basée sur le goût et la texture des objets. Il n''aime pas les choses acides.', 'pkmn_108', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Smogo', 'Lorsque Smogo s''agite, ça augmente la toxicité de ses gaz internes. Il les projette ensuite par les nombreux orifices de son corps. Ce Pokémon peut aussi gonfler son corps et le faire exploser.', 'pkmn_109', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Smogogo', 'Smogogo adore les gaz qui se dégagent des aliments pourris dans les poubelles. Ce Pokémon cherche généralement les maisons sales et mal tenues pour y habiter. La nuit, quand tout le monde est endormi, il fouille les détritus.', 'pkmn_110', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Rhinocorne', 'Rhinocorne charge droit devant lui, détruisant tout sur son passage. Il ne s''arrête jamais, même lorsqu''il charge un bloc d''acier. Malgré tout, il sent la douleur le lendemain.', 'pkmn_111', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Rhinoféros', 'La corne de Rhinoféros peut même casser du diamant brut. Et avec un simple coup de queue, il peut détruire un bâtiment. La peau de ce Pokémon est incroyablement dure. Un boulet de canon ne lui ferait même pas une égratignure.', 'pkmn_112', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Leveinard', 'Leveinard pond tous les jours des œufs pleins de vitamines. Ces œufs sont tellement bons que les gens les mangent même quand ils n''ont pas faim.', 'pkmn_113', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Saquedeneu', 'Les lianes de Saquedeneu se brisent facilement lorsqu''on les attrape. Cela ne lui fait pas mal et lui permet simplement de s''échapper rapidement. Les lianes cassées repoussent le lendemain.', 'pkmn_114', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Kangourex', 'Lorsqu''on rencontre un petit Kangourex qui joue tout seul, il ne faut jamais le déranger ou essayer de l''attraper. Les parents du bébé Pokémon sont sûrement dans le coin et ils risquent d''entrer dans une colère noire. ', 'pkmn_115', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Hypotrempe', 'Hypotrempe mange des petits insectes et de la mousse trouvée sur les cailloux. Lorsque les courants océaniques sont trop forts, ce Pokémon peut s''ancrer en accrochant sa queue aux rochers ou aux coraux. ', 'pkmn_116', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Hypocéan', 'Hypocéan s''accroche aux récifs de corail avant de s''endormir. Les pêcheurs de coraux se font parfois piquer par les aiguillons de ce Pokémon lorsqu''ils ne font pas attention. ', 'pkmn_117', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Poissirène', 'Poissirène est un Pokémon magnifique doté de nageoires qui ondulent élégamment dans les profondeurs. Il ne faut pourtant pas baisser sa garde face à ce Pokémon, car il peut charger avec sa puissante corne. ', 'pkmn_118', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Poissoroy', 'En automne, on peut voir les Poissoroy mâles effectuer des danses nuptiales dans les rivières pour plaire aux femelles. C''est pendant cette saison que le corps de ce Pokémon prend ses plus belles couleurs. ', 'pkmn_119', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Stari', 'Au centre de Stari se trouve un organe rouge et brillant appelé le cœur. À la fin de l''été, sur les plages, les cœurs de ces Pokémon brillent comme les étoiles dans le ciel. ', 'pkmn_120', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Staross', 'Le centre de Staross, son cœur, resplendit de sept différentes couleurs. Du fait de sa brillance naturelle, on appelle ce Pokémon le « joyau des mers ».', 'pkmn_121', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('M. Mime', 'M. Mime est un pantomime hors pair. Ses gestes et ses mouvements parviennent à faire croire que quelque chose d''invisible existe réellement. Lorsqu''on y croit, ces choses deviennent palpables. ', 'pkmn_122', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Insécateur', 'Insécateur est incroyablement rapide. Sa vitesse fulgurante améliore l''efficacité des deux lames situées sur ses avant-bras. Elles sont si coupantes qu''elles peuvent trancher un énorme tronc d''arbre en un coup.', 'pkmn_123', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Lippoutou', 'Lippoutou marche en rythme, ondule de tout son corps et se déhanche comme s''il dansait. Ses mouvements sont si communicatifs que les gens qui le voient sont soudain pris d''une terrible envie de bouger les hanches, sans réfléchir. ', 'pkmn_124', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Elektek', 'Lorsqu''une tempête approche, des groupes entiers de ce Pokémon se battent pour grimper sur les hauteurs, où la foudre a le plus de chance de tomber. Certaines villes se servent d''Élektek en guise de paratonnerres.', 'pkmn_125', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Magmar', 'Lorsqu''il se bat, Magmar fait jaillir des flammes de son corps pour intimider son adversaire. Les explosions enflammées de ce Pokémon déclenchent des vagues de chaleur qui embrasent la végétation environnante. ', 'pkmn_126', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Scarabrute', 'Scarabrute est incroyablement fort. Il peut attraper un ennemi qui pèse deux fois son poids dans ses mandibules et le soulever sans le moindre problème. Lorsqu''il fait froid, les mouvements de ce Pokémon sont un peu ralentis. ', 'pkmn_127', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Tauros', 'Ce Pokémon n''est pas satisfait s''il ne détruit pas tout sur son passage. Lorsque Tauros ne trouve pas d''adversaire, il se rue sur de gros arbres et les déracine pour passer ses nerfs. ', 'pkmn_128', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Magicarpe', 'Magicarpe est un Pokémon ridicule qui ne sait faire que des ronds dans l''eau ou se laisser porter par les courants. Son comportement a donné envie aux savants d''étudier son cas.', 'pkmn_129', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Léviator', 'Quand Magicarpe évolue et devient Léviator, la structure de ses cellules cérébrales est modifiée. On pense que l''extrême violence de ce Pokémon découle de cette modification. ', 'pkmn_130', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Lokhlass', 'Les Lokhlass sont en voie d''extinction. Le soir, on entend ce Pokémon chantonner une complainte mélancolique, espérant retrouver ses rares congénères.', 'pkmn_131', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Métamorph', 'Métamorph peut modifier sa structure moléculaire pour prendre d''autres formes. Lorsqu''il essaie de se transformer de mémoire, il lui arrive de se tromper sur certains détails.', 'pkmn_132', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Évoli', 'Évoli a une structure génétique instable qui se transforme en fonction de l''environnement dans lequel il vit. Ce Pokémon peut évoluer grâce aux radiations de diverses pierres. ', 'pkmn_133', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Aquali', 'Aquali a subi une mutation spontanée. Des nageoires et des branchies sont apparues sur son corps, ce qui lui permet de vivre dans les fonds marins. Ce Pokémon peut contrôler l''eau à volonté.', 'pkmn_134', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Voltali', 'Les cellules de Voltali génèrent un courant de faible intensité. Ce pouvoir est amplifié par l''électricité statique de ses poils, ce qui lui permet d''envoyer des éclairs. Sa fourrure hérissée est faite d''aiguilles chargées d''électricité. ', 'pkmn_135', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Pyroli', 'La fourrure soyeuse de Pyroli a une fonction anatomique. Elle rejette la chaleur dans l''air pour que son corps ne surchauffe pas. La température du corps de ce Pokémon peut atteindre 900 °C.', 'pkmn_136', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Porygon', 'Porygon est capable de se décompiler et de retourner à l''état de programme informatique pour entrer dans le cyberespace. Ce Pokémon est protégé contre le piratage, il est donc impossible de le copier.', 'pkmn_137', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Amonita', 'Amonita est l''un des Pokémon disparus depuis longtemps et qui furent ressuscités à partir de fossiles. Lorsqu''il est attaqué par un ennemi, il se rétracte dans sa coquille. ', 'pkmn_138', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Amonistar', 'Amonistar utilise ses tentacules pour capturer ses proies. On pense que l''espèce s''est éteinte parce que sa coquille était devenue trop grande et trop lourde, ce qui rendait ses mouvements lents et pesants. ', 'pkmn_139', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Kabuto', 'Kabuto est un Pokémon ressuscité à partir d''un fossile. Cependant, on a découvert des spécimens vivants. Ce Pokémon n''a pas changé depuis 300 millions d''années.', 'pkmn_140', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Kabutops', 'Jadis, Kabutops plongeait dans les profondeurs pour trouver ses proies. Apparemment, ce Pokémon vivant sur terre est l''évolution d''une créature marine, comme le prouvent les changements dans ses branchies. ', 'pkmn_141', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Ptéra', 'Ptéra est un Pokémon de l''ère des dinosaures. Il fut ressuscité à partir de cellules extraites d''un morceau d''ambre. On pense qu''il était le roi des cieux à l''époque préhistorique. ', 'pkmn_142', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Ronflex', 'Les journées de Ronflex se résument aux repas et aux siestes. C''est un Pokémon tellement gentil que les enfants n''hésitent pas à jouer sur son énorme ventre.', 'pkmn_143', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Artikodin', 'Artikodin est un Pokémon Oiseau légendaire qui peut contrôler la glace. Le battement de ses ailes gèle l''air tout autour de lui. C''est pourquoi on dit que lorsque ce Pokémon vole, il va neiger.', 'pkmn_144', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Électhor', 'Électhor est un Pokémon Oiseau légendaire capable de contrôler l''électricité. Il vit généralement dans les nuages orageux. Ce Pokémon gagne en puissance lorsqu''il est frappé par la foudre. ', 'pkmn_145', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Sulfura', 'Sulfura est un Pokémon Oiseau légendaire capable de contrôler le feu. On raconte que lorsque ce Pokémon est blessé, il se baigne dans le magma en ébullition d''un volcan pour se soigner.', 'pkmn_146', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Minidraco', 'Minidraco mue constamment, renouvelant sans arrêt sa peau. En effet, l''énergie vitale de son corps augmente régulièrement et sa mue lui permet d''éviter d''atteindre des niveaux incontrôlables. ', 'pkmn_147', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Draco', 'Draco stocke une quantité d''énergie considérable dans son corps. On raconte qu''il peut modifier les conditions climatiques autour de lui en déchargeant l''énergie contenue dans les cristaux de son cou et de sa queue.', 'pkmn_148', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Dracolosse', 'Dracolosse est capable de faire le tour de la planète en seize heures à peine. C''est un Pokémon au grand cœur qui ramène à bon port les navires perdus dans les tempêtes. ', 'pkmn_149', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Mewtwo', 'Mewtwo est un Pokémon créé par manipulation génétique. Cependant, bien que les connaissances scientifiques des humains aient réussi à créer son corps, elles n''ont pas pu doter Mewtwo d''un cœur sensible.', 'pkmn_150', 0);");
        db.execSQL("insert into pokemon (name, description, imgName, isFav) values ('Mew', 'On dit que Mew possède le code génétique de tous les autres Pokémon. Il peut se rendre invisible à sa guise, ce qui lui permet de ne pas se faire remarquer quand il s''approche des gens.', 'pkmn_151', 0);");

        db.close();
    }

    /*
     * MB : Permet d'insérer un objet Pokémon en base de données
     */
    public void insertPokemon(Pokemon pkmn) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", pkmn.getName());
        values.put("description", pkmn.getDescription());
        values.put("imgName", pkmn.getImageName());
        values.put("isFav", pkmn.isFavourite());
        database.insert("pokemon", null, values);
        database.close();
    }

    /*
     * MB : Met à jour un objet Pokémon dans la base de données
     */
    public void updatePokemon(Pokemon pkmn) {
        SQLiteDatabase database = this.getWritableDatabase();
        String strFilter = "id=" + pkmn.getId();
        ContentValues values = new ContentValues();
        values.put("name", pkmn.getName());
        values.put("description", pkmn.getDescription());
        values.put("imgName", pkmn.getImageName());
        values.put("isFav", pkmn.isFavourite());

        database.update("pokemon", values, strFilter, null);

        Pokemon newPkmn = getPokemon(pkmn.getId());
        Log.v("dexter", newPkmn.getName() + " favori : " + newPkmn.isFavourite());

        database.close();
    }

    /*
     * MB : Récupère la liste complète des Pokémon
     */
    public ArrayList<Pokemon> getAllPokemons() {

        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

        String selectQuery = "SELECT  * FROM pokemon";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                String imgName = cursor.getString(3);
                Boolean isFav = cursor.getInt(4) > 0;
                pokemons.add(new Pokemon(id, name, description, imgName, isFav));
            } while (cursor.moveToNext());
        }

        database.close();

        // return contact list
        return pokemons;
    }

    /*
     * MB : Récupère la liste des Pokémon marqués comme favoris
     */
    public ArrayList<Pokemon> getFavouritePokemons() {

        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

        String selectQuery = "SELECT  * FROM pokemon WHERE isFav > 0";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                String imgName = cursor.getString(3);
                Boolean isFav = cursor.getInt(4) > 0;
                pokemons.add(new Pokemon(id, name, description, imgName, isFav));
            } while (cursor.moveToNext());
        }

        database.close();

        // return contact list
        return pokemons;
    }

    /*
     * MB : Récupère la liste des Pokémon dont le nom contient
     * la chaine passée en paramètre
     */
    public ArrayList<Pokemon> getPokemons(String name) {

        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

        String selectQuery = "SELECT  * FROM pokemon WHERE name LIKE '%" + name + "%'";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String pname = cursor.getString(1);
                String description = cursor.getString(2);
                String imgName = cursor.getString(3);
                Boolean isFav = cursor.getInt(4) > 0;
                pokemons.add(new Pokemon(id, pname, description, imgName, isFav));
            } while (cursor.moveToNext());
        }

        database.close();

        // return contact list
        return pokemons;
    }

    /*
     * MB : Récupère uhn objet Pokémon à partir de son ID
     */
    public Pokemon getPokemon(int id) {

        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM pokemon where id='" + id + "'";
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            String imgName = cursor.getString(3);
            Boolean isFav = cursor.getInt(4) > 0;

            database.close();

            return new Pokemon(id, name, description, imgName, isFav);
        }

        database.close();

        return null;
    }

    /*
     * MB : Méthode appelée lorsque la base de données doit être mise à niveau
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query;
        query = "DROP TABLE IF EXISTS pokemon";
        db.execSQL(query);
        onCreate(db);
    }
}
