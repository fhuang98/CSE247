package dh.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import dh.DH;
import dh.utils.DHFactory;

public class TestDH {

	private static final long[] privs = new long[] { 0L, 1L,  2L,   3L, 376752573L, 1335520066L, 811766449L, 286015724L, 782241515L, 139532828L, 757135147L, 1464713889L, 1444906836L, 1563852545L, 101060046L, 600838463L, 98243486L, 962774138L, 149250089L, 1295636227L, 957114273L, 603911798L, 748947360L, 967787322L, 545810359L, 13381707L, 493916759L, 344961756L, 1452015313L, 1322043639L, 1352253025L, 1390649277L, 185379103L, 1477608763L, 1146181599L, 322317737L, 1158995370L, 1512217979L, 1489299924L, 1151213243L, 1509081347L, 877716722L, 1133266706L, 82201942L, 1352231951L, 790133070L, 1131910570L, 556396289L, 499319916L, 1373661818L, 862216731L, 162024999L, 151973555L, 809563614L, 1272356847L, 109497778L, 1307816434L, 1929823L, 319789555L, 1314649883L, 1221682004L, 1496510336L, 1257877869L, 204032437L, 1154429832L, 781068211L, 715292772L, 1493272588L, 1418289041L, 396297395L, 1081705836L, 685872689L, 886466321L, 755539030L, 1050799038L, 1167937517L, 1196624911L, 225762270L, 1507630828L, 596381420L, 893035682L, 963011598L, 453802199L, 1064079255L, 1543164370L, 133471302L, 811394176L, 81956588L, 789940948L, 316903699L, 905743091L, 1028844458L, 267650412L, 506368200L, 977273294L, 1162807654L, 1075431697L, 408170695L, 279488421L, 1346427086L, 1044314664L, 201945485L, 883440870L, 695018895L, 814430000L, 219652426L, 1507764190L, 1003411552L, 422670158L, 1122206552L, 1192335993L, 471632531L, 827292358L, 565038615L, 891792081L, 1348467385L, 90907598L, 105057226L, 242892041L, 574113766L, 735481874L, 462657510L, 1127286550L, 595742279L, 418974770L, 382054526L, 1391940968L, 1062519664L, 109149526L, 1533821944L, 18708209L, 704880245L, 1564461952L, 633966803L, 1357061260L, 1305542884L, 235426527L, 1437310591L, 502739812L, 514660221L, 45490144L, 16288982L, 855979391L, 1145922153L, 4102018L, 185795434L, 1187973433L, 281624141L, 1020129725L, 120159092L, 1295711784L, 1521541594L, 626038562L, 17929160L, 99727877L, 582928208L, 702232299L, 242072166L, 64092763L, 1366241063L, 979780272L, 1494114905L, 1432155013L, 964043419L, 163769254L, 1167015081L, 215250375L, 1412489992L, 1024526840L, 45974280L, 406183182L, 1095722525L, 608511143L, 807654673L, 584474206L, 459935188L, 1296401333L, 88428721L, 1098785352L, 753347688L, 934436634L, 1055172536L, 332465492L, 181389649L, 135390068L, 1186854258L, 145571039L, 576106062L, 1285666765L, 899708033L, 65253686L, 1037472465L, 807055280L, 1302362790L, 1300673570L, 675747494L, 338882342L, 1276876696L, 766586011L, 746185395L, 564623256L, 1131764183L, 316330942L, 177659207L, 1213800433L, 1457376973L, 1299746428L, 1121440542L, 440938736L, 844339654L, 1267246287L, 1525243659L, 807522911L, 1059884071L, 1411175915L, 920577402L, 1489663951L, 129631295L, 446678588L, 1541973126L, 705848638L, 15962728L, 1032713740L, 1463421507L, 132326148L, 1398354995L, 393504399L, 1526361619L, 1032903038L, 336959615L, 165771670L, 169132678L, 1434533921L, 12351403L, 1333918203L, 1083328887L, 816539745L, 617055986L, 76810045L, 1423575470L, 77890015L, 27402937L, 959749745L, 319751558L, 1375995107L, 368872546L, 46473652L, 507938663L, 1232543729L, 553422902L, 824294504L, 379277980L, 523493063L, 1306129109L, 216969511L, 186785739L, 1548097790L, 666382909L, 1156018275L, 1105053432L, 92191119L, 1408795090L, 308337959L, 1137762769L, 491390957L, 1552113504L, 1246453410L, 1106591659L, 127974947L, 460052846L, 1566710587L, 932300165L, 87906481L, 549602479L, 1538678586L, 328452655L, 357491133L, 1528033357L, 51733578L, 293575174L, 873476533L, 1533919238L, 1138780368L, 69047239L, 418232561L, 1325300298L, 171830654L, 1057397407L, 18113421L, 774825503L, 36288794L, 1414312398L, 557220608L, 971458737L, 1419845749L, 1135980409L, 574112205L, 159917360L, 393487707L, 1022387196L, 466317616L, 1555177181L, 95615815L, 1279523437L, 533537563L, 198418321L, 1274966956L, 1060476269L, 1077392567L, 845492603L, 299877634L, 1536324734L, 516879104L, 44458300L, 545249287L, 1498713087L, 1181671628L, 740852706L, 425934603L, 643523156L, 1362813846L, 805102823L, 1499190199L, 995759250L, 1426409659L, 1009005055L, 1512818941L, 286514481L, 443268654L, 90513196L, 750621677L, 824878304L, 176369412L, 1468517321L, 1074262415L, 1011996190L, 1550300047L, 70364633L, 1351070922L, 644598963L, 96606699L, 650524807L, 1200149147L, 385881006L, 110940951L, 401125951L, 158799929L, 705391414L, 1468815990L, 1145777572L, 785770310L, 922702593L, 1245121029L, 1265775241L, 34372290L, 1090990754L, 31889095L, 243685349L, 581070136L, 596887109L, 502646471L, 1102818121L, 615824830L, 180295429L, 527426567L, 168754423L, 945501062L, 1136130605L, 287240427L, 1304807642L, 1115153580L, 160881701L, 291157750L, 568932751L, 280581008L, 1308281632L, 1525343909L, 945940713L, 155989498L, 168291008L, 680218062L, 98777912L, 1386546218L, 1458596958L, 1187956366L, 1104486936L, 724727475L, 569990896L, 1027515674L, 275035651L, 1242193287L, 204952649L, 443720680L, 660697792L, 1370467088L, 565158575L, 1219640237L, 1250516275L, 1354501400L, 323109643L, 546861824L, 30711580L, 645419735L, 1193629572L, 777467412L, 466164525L, 1144702410L, 1237653259L, 459978261L, 677971362L, 451103795L, 484987483L, 658754881L, 12164794L, 132253898L, 539417100L, 1414580716L, 1485176103L, 1303948635L, 578642252L, 1195521600L, 599465811L, 1294730925L, 270947475L, 509092509L, 360233838L, 1314551143L, 73929050L, 1064552650L, 187416209L, 1225369881L, 95756090L, 1168446474L, 1547477661L, 1278852725L, 390355962L, 1386654829L, 916137944L, 1525128667L, 1302382713L, 217791348L, 1099361845L, 1184786388L, 329410175L, 598237047L, 527646589L, 1130540956L, 1475436850L, 990791218L, 573545578L, 391034389L, 974834117L, 1395851074L, 809497482L, 562728202L, 341443582L, 1344034450L, 1279291834L, 76855763L, 982739792L, 533180486L, 737941774L, 1146608319L, 171500978L, 1342276453L, 1301377979L, 857700254L, 624653473L, 1179070557L, 1539654690L, 1538055365L, 657466982L, 164889330L, 818355344L, 277446948L, 31025529L, 649413042L, 254261686L, 342561368L, 559517336L, 599019228L, 1312503913L, 252304307L, 75197054L, 579228853L, 257188577L, 1224871479L, 890394157L, 682633424L, 131254203L, 648868338L, 241684436L, 694645344L, 554899721L, 284415158L, 1197719126L, 723409375L, 467624538L, 1215833732L, 1424019058L, 150350380L, 243346657L, 643503229L, 535670709L, 98106663L, 1062513644L, 768434680L, 625321411L, 1529158909L, 10875155L, 586716077L, 350611206L, 656719857L, 1432808241L, 408331273L, 130320575L, 278914591L, 1335430788L, 110827160L, 396538543L, 1060874930L, 902863005L, 397261219L, 1306341729L, 212212126L, 831048290L, 835777624L, 256055981L, 599993248L, 1116704578L, 852803239L, 111596302L, 1273398796L, 1504615633L, 164701031L, 923588771L, 830071802L, 198203698L, 774710438L, 1498270519L, 1041850333L, 1412474836L, 450093312L, 191125148L, 288344833L, 809389451L, 444782104L, 677763527L, 38143174L, 666074551L, 733831297L, 29699312L, 549784580L, 1387109057L, 544725578L, 386889903L, 598007575L, 96597100L, 2232332L, 902293805L, 661363378L, 546450590L, 598396857L, 1113501299L, 390352208L, 867481954L, 1386606992L, 1083129046L, 633472720L, 1375576998L, 444491986L, 1441144596L, 306956454L, 925917246L, 1204237409L, 1297333717L, 1231487204L, 1120903615L, 745306443L, 107866623L, 384626371L, 861494027L, 731813033L, 1533977724L, 1533953075L, 167946261L, 510305537L, 211468604L, 559828311L, 1450475282L, 1068342568L, 503459378L, 23891142L, 26351266L, 1486695853L, 410606269L, 1183569910L, 733989198L, 1464428511L, 519997220L, 160479309L, 1120955198L, 1278930551L, 1174909703L, 163381898L, 502916483L, 1344134620L, 1160527092L, 222850871L, 1152885617L, 885013320L, 139577831L, 1001960269L, 249616573L, 1299947587L, 145060520L, 480073435L, 1064112901L, 678838657L, 1392785611L, 234528112L, 244001307L, 609107309L, 176841475L, 60661456L, 400130927L, 516115635L, 138959925L, 1172186029L, 326221040L, 799362326L, 1443839613L, 1199224623L, 252551491L, 406112998L, 1263618232L, 540830484L, 1309551922L, 715504322L, 93338689L, 1446996929L, 982143832L, 993767105L, 1538435783L, 1544566987L, 773745337L, 1324376055L, 1222284264L, 842310524L, 1105983748L, 1426731069L, 1212905996L, 56523047L, 1566675014L, 340111681L, 1093272300L, 1412966099L, 430892385L, 960619900L, 1322322810L, 250524876L, 194602552L, 946197041L, 603333381L, 907325313L, 1467758599L, 106394257L, 463311974L, 1227323492L, 1238077992L, 712129558L, 260502595L, 876622990L, 307047289L, 1234592669L, 30119147L, 75991795L, 437004534L, 1068494434L, 410738643L, 1272317727L, 1462668579L, 1186944857L, 1171781588L, 1216185L, 1560810890L, 291301098L, 1037328558L, 115373397L, 37592964L, 182650661L, 795310052L, 1187800853L, 1407927821L, 262730689L, 1164699892L, 764749523L, 105556056L, 1099646648L, 621698915L, 1389771399L, 525868414L, 1420427464L, 1235017058L, 82570932L, 790668866L, 86734031L, 1362976108L, 1229655481L, 1132594882L, 450250438L, 598983440L, 81148469L, 135405758L, 1243155262L, 1490322718L, 631434389L, 78680655L, 1266364660L, 1111903510L, 216943110L, 306733502L, 178114324L, 83656823L, 854082970L, 913008192L, 1200343414L, 230544747L, 1274105016L, 1309917446L, 1195007888L, 406193185L, 1480981028L, 901755965L, 1053220436L, 958474252L, 1396329500L, 1564508849L, 764734519L, 1498374543L, 504607707L, 1011884521L, 284647039L, 380458545L, 142143773L, 223629029L, 621416178L, 321383902L, 261013167L, 483547644L, 196094821L, 1535665928L, 169823798L, 650178639L, 1029948401L, 251511802L, 1522059148L, 261662983L, 77659361L, 794051276L, 1556745679L, 1555323589L, 1354553770L, 102208277L, 829541617L, 1031492254L, 1486020543L, 438093519L, 366068657L, 464200133L, 1080393148L, 187667812L, 1131760032L, 608953110L, 854942404L, 502016126L, 1354881718L, 454609419L, 256445529L, 1177081426L, 1401723447L, 347437621L, 785922445L, 1158853354L, 1429220251L, 933789863L, 25053489L, 274926248L, 1530732553L, 58735904L, 769486483L, 613226963L, 1224513868L, 357932099L, 891534900L, 1496498212L, 48305760L, 568773210L, 939371102L, 1120387931L, 1160505695L, 220781351L, 138217012L, 1230999342L, 1245102701L, 90316524L, 1513735714L, 123954609L, 902154907L, 133367503L, 495273627L, 98999331L, 1421916237L, 751975686L, 906100957L, 515884481L, 169432617L, 1508244995L, 721738602L, 564243555L, 473822764L, 1514619059L, 496853771L, 814473593L, 144579807L, 1481540903L, 264314912L, 1380283601L, 403438960L, 829923699L, 1110039649L, 1416917124L, 211657900L, 328792301L, 251281637L, 904742088L, 928536018L, 646410391L, 1213194534L, 824924675L, 607238793L, 437485127L, 1019008616L, 1194227330L, 686809878L, 193272348L, 369573839L, 1113285924L, 489766511L, 407577531L, 151710296L, 973776481L, 748537166L, 1530575853L, 1177265104L, 388112715L, 1019781793L, 830748397L, 694377475L, 1262864400L, 1059078024L, 246947261L, 798086728L, 1561868519L, 1438416993L, 384177199L, 1319784550L, 238404488L, 300665677L, 1116235111L, 1324776525L, 1171050359L, 23024210L, 1168721206L, 279566832L, 89672039L, 1412358163L, 425413810L, 421636048L, 385493465L, 1442594777L, 1422018878L, 681286205L, 302025051L, 461725624L, 606744263L, 1264842557L, 128033607L, 1009671621L, 1097053024L, 189190572L, 819476113L, 1403782184L, 1222724527L, 68840768L, 709685390L, 1175672163L, 530159654L, 1034967612L, 498299114L, 899364557L, 823409509L, 467353856L, 317933016L, 764813489L, 1081728894L, 1399058248L, 1358230712L, 559053254L, 1023245624L, 1044646000L, 639062186L, 627943826L, 747922510L, 698679813L, 1182395616L, 1179079959L, 147454105L, 1331941203L, 1163513531L, 366571055L, 1527407395L, 126149173L, 110201570L, 73904170L, 815564108L, 1117770256L, 804251260L, 466587606L, 1355720769L, 121985731L, 342843480L, 1502151547L, 447711596L, 325458746L, 391792684L, 1311916400L, 945395963L, 1514709548L, 1227412363L, 922924694L, 1276508041L, 260647589L, 1104338200L, 1558286463L, 572647097L, 471033374L, 192520948L, 1240721576L, 601434110L, 261150420L, 1088667032L, 66892347L, 715871600L, 35585478L, 1561881418L, 594732519L, 824156400L, 910072656L, 920829703L, 349692096L, 888497826L, 677742603L, 1479744375L, 1545877301L, 590894670L, 978773391L, 1241512903L, 798958795L, 1469420551L, 1078538921L, 1400076805L, 510640316L, 913701214L, 1368861805L, 622771612L, 116310182L, 578348339L, 828959231L, 199050877L, 1480762827L, 1477887803L, 1058396436L, 1238286229L, 902232804L, 201948509L, 366382392L, 682772628L, 1326992494L, 1055892269L, 1498615974L, 1172130867L, 194328184L, 72525863L, 1267579401L, 1428676110L, 1450622727L, 208629761L, 315600238L, 988261554L, 1019965543L, 566613340L, 1545943265L, 1012095783L,};
	private static final long[] pubs = new long[]  { 1L, 5L, 25L, 125L, 1089816305L, 603220837L, 38480375L, 395793187L, 371265755L, 985639861L, 303170543L, 370152287L, 1452284251L, 240900293L, 242070511L, 1145532407L, 867657319L, 275830357L, 1440529733L, 1383765467L, 1540405985L, 205605907L, 1075789315L, 960753619L, 849258311L, 1044942155L, 883764533L, 1201014493L, 907876157L, 756527315L, 707693159L, 637834511L, 1153725551L, 179437289L, 1391864753L, 1320846971L, 825520987L, 206753765L, 1189529245L, 314837141L, 1331613215L, 958148425L, 1506835111L, 1214330683L, 439238879L, 708503413L, 1303629961L, 1033734053L, 1125248893L, 631383367L, 642361793L, 917022929L, 611108303L, 398935579L, 783146639L, 1536963967L, 1041272995L, 1210219469L, 1500724715L, 1207377851L, 1278784663L, 657439579L, 1260503573L, 1037974703L, 1341481063L, 46691951L, 254834533L, 97296565L, 1271491007L, 455118905L, 853450573L, 852046379L, 133242101L, 692443111L, 629181757L, 201946841L, 980603783L, 1264703977L, 1005092341L, 96588757L, 955714135L, 1279602091L, 1493951981L, 1518257663L, 1232241169L, 622127665L, 571144207L, 415149049L, 746912701L, 682779833L, 811784027L, 780021223L, 1229690359L, 1203026431L, 65818585L, 319258945L, 1578239L, 580193183L, 787336619L, 1276234249L, 573548161L, 578028035L, 701618803L, 1006987127L, 1022040577L, 1452177289L, 236199139L, 785417617L, 217684069L, 253254433L, 914688917L, 1391512889L, 1117734229L, 875623439L, 657258893L, 68703143L, 26062609L, 1055927779L, 822720713L, 1330128625L, 304086487L, 34971991L, 20825521L, 634049075L, 1490968897L, 28599403L, 783291727L, 470993557L, 1493364385L, 654436705L, 1271966189L, 1305424415L, 1434218737L, 464124575L, 367576321L, 1342262713L, 471761057L, 697329989L, 1091110843L, 1090262345L, 648188041L, 576084865L, 1126969325L, 1208568941L, 269360767L, 1064260555L, 677530181L, 1405212863L, 613613759L, 680026399L, 875865535L, 768449869L, 836661547L, 322569913L, 1180447655L, 258964963L, 940898165L, 894982717L, 1165202033L, 722937671L, 760805827L, 1566451871L, 1167663941L, 794201525L, 443510731L, 1060640087L, 1558107437L, 251343277L, 585100657L, 850266913L, 1404742813L, 1348289633L, 447571343L, 1224195311L, 1542141691L, 545202157L, 1343275787L, 1441100663L, 1559583877L, 436737895L, 1038714601L, 676585057L, 338593963L, 1465273061L, 1124101663L, 1311683821L, 237756269L, 972230467L, 857909069L, 1148156435L, 160727617L, 666833153L, 746531311L, 1392452797L, 375875569L, 567831757L, 358296691L, 4462135L, 1526489741L, 763829879L, 183817165L, 983299205L, 1261989211L, 152406935L, 763995377L, 227554703L, 1387870219L, 1347750559L, 198950599L, 908907367L, 966963137L, 861576755L, 514259627L, 632778521L, 816915791L, 216709627L, 1059270377L, 517513913L, 157892953L, 557156017L, 1511294473L, 1119119743L, 1312254391L, 593134061L, 1292961475L, 1062234833L, 779683067L, 524725853L, 687135481L, 304448261L, 763990339L, 691459369L, 1274563085L, 1515411503L, 1086819383L, 1165755161L, 1270037591L, 1371054889L, 814631477L, 251632999L, 1153369697L, 1071335711L, 1341869897L, 302915593L, 971748047L, 504243193L, 1250374177L, 1304049743L, 92457197L, 1032993943L, 1278178723L, 1371978577L, 914564567L, 372529685L, 953651549L, 946815479L, 325708237L, 1420072511L, 93114491L, 518696449L, 1383239927L, 857083717L, 215554103L, 1370928845L, 899270009L, 1545073555L, 1387992529L, 256707071L, 143375609L, 1102375213L, 391066025L, 780417083L, 1017417767L, 1003815065L, 1323893149L, 762267923L, 225481511L, 1116073343L, 1028282329L, 1417146889L, 608872751L, 283599559L, 1524014113L, 848740271L, 564520157L, 194861689L, 1517324143L, 1454692457L, 1283206793L, 956885237L, 802369909L, 573334777L, 768962413L, 494887313L, 145868537L, 1551983063L, 864425111L, 1348228417L, 222294767L, 471104611L, 615548647L, 583944299L, 88122257L, 49620083L, 364914641L, 473544305L, 602953699L, 1426477259L, 495785699L, 134487593L, 490564531L, 1210848499L, 858955375L, 1024771189L, 1388585267L, 377685617L, 810151615L, 908285335L, 498738269L, 165687667L, 1534819519L, 1413884123L, 1565398103L, 167989633L, 449443769L, 1307885657L, 114008291L, 132905849L, 1250489881L, 48546121L, 562267889L, 194013505L, 654710281L, 1140976967L, 884920481L, 804753247L, 73503569L, 316232375L, 915455005L, 535159553L, 851395553L, 482293709L, 340704959L, 1019991103L, 252734945L, 353266535L, 153877037L, 727982395L, 608300425L, 342600247L, 1390729921L, 507676499L, 1537427567L, 863663159L, 30690217L, 270654037L, 1441637345L, 148538261L, 816237469L, 1031090375L, 1119818513L, 136459421L, 191679637L, 1232751107L, 354951881L, 496865849L, 1539994405L, 865002869L, 44716049L, 1537275487L, 472813261L, 584913767L, 504568681L, 268627385L, 1095092779L, 665629459L, 120562193L, 1375370693L, 414725719L, 749076553L, 603199585L, 1525080541L, 351390685L, 602615509L, 576560155L, 881973091L, 520589381L, 64090597L, 780443359L, 1507077029L, 554854487L, 1161715025L, 430061233L, 1377834985L, 1440333235L, 699781151L, 881973779L, 59565545L, 503535715L, 763521881L, 300782659L, 568892299L, 670002191L, 262478401L, 891834799L, 821544299L, 490008307L, 426255347L, 244192901L, 1299048091L, 1355328227L, 586259183L, 1255023149L, 807485365L, 1028611627L, 1167735679L, 915449869L, 1101949139L, 485432225L, 430077829L, 1006871749L, 644469881L, 490039517L, 688072379L, 1311021119L, 587980921L, 1259174687L, 855971821L, 999956959L, 586805813L, 228752495L, 159572617L, 11441815L, 704459975L, 1522706213L, 1367542987L, 870883343L, 593513899L, 1018736549L, 344238191L, 946068355L, 394261853L, 1366982161L, 376027277L, 440264669L, 701232029L, 369897199L, 7745269L, 538486213L, 930106969L, 1065850685L, 861166757L, 900655519L, 200290051L, 106471207L, 1509232303L, 751032367L, 1096818703L, 105777869L, 1296591463L, 1124248399L, 316552921L, 22937087L, 371479495L, 248817023L, 207134765L, 501069787L, 985387325L, 719438489L, 1416314161L, 52703711L, 307093693L, 1222954819L, 1544375143L, 415985587L, 1156734413L, 1559579701L, 1026846415L, 1523544349L, 255473473L, 239821087L, 852646397L, 13100393L, 549128467L, 397320155L, 1364050079L, 1432665533L, 1204584365L, 814329661L, 418613207L, 1466467099L, 626139991L, 567369103L, 1405707197L, 458625397L, 1256842063L, 667427585L, 1458002293L, 783104833L, 984063925L, 1459261303L, 1531549139L, 1289266601L, 890810765L, 693910283L, 627300409L, 535889755L, 612971855L, 1096420403L, 1327277435L, 584335217L, 1472911615L, 406274903L, 1019818445L, 717782303L, 167542445L, 835719065L, 419908867L, 415423261L, 98456783L, 952906819L, 1278704699L, 411146183L, 1002666269L, 1329877813L, 885806737L, 215660311L, 311076137L, 837898243L, 112157089L, 980509601L, 1029764815L, 1530345235L, 1215680489L, 640528895L, 915305999L, 1567591753L, 467842453L, 1060823557L, 141157589L, 781560239L, 1095849559L, 960132637L, 172965691L, 796153241L, 631258415L, 1201428499L, 1314607715L, 192749725L, 643343933L, 1498591277L, 1332067135L, 841958971L, 1116180725L, 1521046411L, 1148724239L, 385273433L, 575360353L, 224531755L, 1200137027L, 375409069L, 1210284619L, 663888047L, 803085035L, 506285473L, 87434761L, 349831633L, 533594611L, 1187437093L, 791452459L, 718416643L, 1316173519L, 249192289L, 410090755L, 1283598071L, 145244825L, 209690881L, 62389973L, 731002601L, 1410036359L, 1127796743L, 669288959L, 42614831L, 35812861L, 981311909L, 145643345L, 932639975L, 1277176081L, 214520525L, 1283311705L, 540320785L, 1556604481L, 531093307L, 543485695L, 1381235951L, 1260351215L, 324260779L, 233118295L, 1240383599L, 830946241L, 731586611L, 1153286695L, 1241996843L, 300147203L, 90958897L, 160298435L, 1040923837L, 857640589L, 163491749L, 1421010341L, 380709559L, 1111517489L, 72485537L, 1048671425L, 635162057L, 1536039511L, 232751663L, 1397414975L, 1557186263L, 912746861L, 454018249L, 601739525L, 1349272943L, 1365059453L, 851695495L, 333701117L, 1009737629L, 814062503L, 181723685L, 152710057L, 1502604583L, 428885981L, 1288212935L, 1184117687L, 958515853L, 138683713L, 305894629L, 421003075L, 1103509069L, 12174641L, 1371350807L, 1533657649L, 1058658005L, 1152841319L, 1224048545L, 417511997L, 333783551L, 920247985L, 862970029L, 181425817L, 52664201L, 279238429L, 1420051751L, 361911163L, 923901779L, 1197151435L, 448805351L, 968219297L, 1392944095L, 818253571L, 407301193L, 1000063141L, 1285446299L, 1042319987L, 592008845L, 545969651L, 844322045L, 843929935L, 605186407L, 1090211371L, 1485763201L, 1077480359L, 1483323739L, 260534825L, 567653399L, 269097989L, 578703125L, 1354371085L, 1486477195L, 595545671L, 372648599L, 530740715L, 365334023L, 1230283213L, 1389652145L, 286851877L, 867704323L, 166367461L, 1135191401L, 758422285L, 1042969901L, 664987417L, 810011615L, 827635937L, 641588135L, 310953451L, 75477929L, 99839971L, 253531903L, 958208981L, 411514409L, 757440949L, 481144321L, 1477712335L, 1121060371L, 524680915L, 1395446333L, 359217331L, 73782113L, 1340946565L, 922717225L, 1386121891L, 686027165L, 309695011L, 1455556699L, 354142381L, 1505129147L, 1028646215L, 1385025673L, 565405387L, 162944179L, 1103663197L, 399601777L, 626219297L, 342017905L, 1318155241L, 1430174041L, 882366659L, 490786555L, 2346883L, 101378077L, 1535704019L, 1302729703L, 1533235517L, 65973985L, 1116657655L, 888487885L, 187877477L, 181121471L, 1528032599L, 692733557L, 1508373041L, 1157183045L, 849958787L, 196362041L, 919117061L, 901649089L, 136108039L, 836475713L, 1525586107L, 1286313611L, 1162294297L, 391110289L, 485485043L, 576646091L, 1424846107L, 152344369L, 1458004709L, 832097993L, 56026123L, 445503761L, 1302815027L, 1447574281L, 1518291947L, 903157739L, 662005501L, 1384113563L, 261581771L, 842708081L, 56223485L, 1170251119L, 250850995L, 989135881L, 1514044345L, 1526903215L, 129499525L, 53461153L, 448681967L, 674371841L, 998006473L, 1161807287L, 900819335L, 806597975L, 1241696521L, 1155010781L, 1154207039L, 560865143L, 1509003865L, 98040083L, 117860737L, 1313108285L, 893888789L, 519931513L, 396132539L, 985358647L, 188500813L, 11427337L, 1058973133L, 115864309L, 643219517L, 913067567L, 1112792015L, 1035057961L, 513876421L, 881429873L, 588024415L, 721829641L, 1361806895L, 547307429L, 49598747L, 81846539L, 1137214451L, 630470417L, 843366361L, 49601327L, 869103653L, 1326862535L, 789749831L, 1211783137L, 1146905L, 892548601L, 109287539L, 649646429L, 1490553623L, 1387222619L, 450784049L, 255822931L, 1029018443L, 799949119L, 1502735753L, 936806549L, 798239197L, 1250421727L, 1102235363L, 1160331767L, 1419678025L, 566687653L, 58695473L, 920039185L, 941402513L, 269887445L, 405437315L, 550524337L, 787275565L, 1170482677L, 1557825817L, 1424661185L, 760899553L, 1196603741L, 921280415L, 339372613L, 701384885L, 65117929L, 1028501237L, 1197550051L, 433167599L, 1474279787L, 627251135L, 1553268425L, 226012249L, 161497963L, 889210085L, 1353081937L, 566930567L, 459894047L, 1329639347L, 579018253L, 1090188085L, 117200309L, 1379231369L, 498506615L, 828941789L, 65232991L, 575693761L, 96058105L, 467560889L, 138569399L, 507780631L, 551744383L, 1285174703L, 1044224507L, 132970543L, 1151564957L, 1104578051L, 249224125L, 1481781695L, 808021295L, 1351007831L, 1373863901L, 1377828451L, 937292449L, 1516677185L, 877745533L, 743141429L, 706949221L, 529393123L, 341364665L, 339552445L, 733332037L, 1400097199L, 134905223L, 1551846989L, 113628751L, 1208268991L, 1105760603L, 1211064031L, 230371249L, 1083928693L, 533486179L, 1125402397L, 568722049L, 1024201171L, 884759419L, 1219499767L, 1262126123L, 1039549231L, 1534172033L, 822436511L, 1367821607L, 634877903L, 864851639L, 420592925L, 1274607473L, 32234035L, 38535727L, 679378651L, 1193658517L, 33628579L, 135935347L, 506050613L, 716303261L, 807610273L, 1069034951L, 1136761417L, 1258326487L, 1192181599L, 671439421L, 1217617607L, 1198137583L, 1480380359L, 924121291L, 1510001435L, 708091091L, 930742975L, 2255135L, 1547313671L, 751095037L, 871016917L, 262703221L, 380307415L, 1490994355L, 329852197L, 1483517543L, 766094137L, 652731883L, 1040124205L, 732640265L, 742666219L, 961355839L, 328994429L, 1323610399L, 1242919159L, 1284556355L, 1247116949L, 807679703L, 903532237L, 1377089543L, 1190778167L, 1046069729L, 1004104301L, 585677087L, 475003373L, 1374944491L, 738992473L, 597063743L, 715373215L, 558124639L, 1192563503L, 443144885L, 1179538799L, 1076601971L, 364365521L, 1305755965L, 456657395L, 1561590667L, 172453535L, 789001105L, 801494845L, 818482201L, 1533566987L, 834328921L, 1110518591L, 207320383L, 532567823L, 628901015L, 1127474155L, 1125807089L, 779272943L, 1376079511L, 490785913L, 201114185L, 245949517L, 726528443L, 368450237L,};


	@Test
	public void testLectureExample() {
		DHFactory dhf = new DHFactory(5, 23);
		DH alice = dhf.nextDH(6);
		DH bob   = dhf.nextDH(15);
		assertEquals("Alice's public key should be 8 for private key 6", 8,  alice.getPubKey());
		assertEquals("Bob's public key should be 19 for private key 15", 19, bob.getPubKey());
		assertEquals("Alice and Bob agree on 2", 2,  alice.getAgreedNum(19));
		assertEquals("Alice and Bob agree on 2", 2,  bob.getAgreedNum(8));
	}

	@Test
	public void testPubKeys() {
		DHFactory dhf = new DHFactory(DHFactory.BASE, DHFactory.LARGEPRIME);
		for (int i=0; i < privs.length; ++i) {
			long priv = privs[i];
			DH   dh   = dhf.nextDH(priv);
			long pub  = dh.getPubKey();
			assertEquals("For private key " + priv + " incorrect computation of public key", pubs[i], pub);
		}
	}

	@Test
	public void testAgreement() {
		DHFactory dhf = new DHFactory(DHFactory.BASE, DHFactory.LARGEPRIME);
		for (int i=1; i < privs.length; ++i) {
			long priv = privs[i];
			DH   dh   = dhf.nextDH(priv);
			long pub  = dh.getPubKey();

			long privBefore = privs[i-1];
			DH dhbefore = dhf.nextDH(privBefore);
			long pubBefore  = pubs[i-1];

			assertEquals("Agreement failed for private keys " + priv + " and " + privBefore, dh.getAgreedNum(pubBefore), dhbefore.getAgreedNum(pub));

		}
	}
}
