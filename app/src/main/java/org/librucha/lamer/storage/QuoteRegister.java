package org.librucha.lamer.storage;

import org.librucha.lamer.domain.Quote;

import java.util.*;

public class QuoteRegister {

  private final Map<Integer, Quote> quotes = new HashMap<Integer, Quote>();

  private QuoteRegister() {
	loadData();
  }

  private void loadData() {
	quotes.put(0, new Quote(1, "<a> ty prosimtě, zařídila jsem prohlídku toho bytu co se mi tak líbíl, kdy máš čas?\n" +
			"<b> já ti ale řekl že je 1) moc malej, 2) moc drahej, 3)kuchyň stojí pěkně za hovno\n" +
			"<a> mně se ale líbí takže se tam půjdem podívat ať chceš nebo nechceš. Kdy se ti to hodí?\n" +
			"<b> no tenhle týden tady mám delegaci z ciny takze ne driv jak 29-30 unora\n" +
			"<a> oki, zaridim to na 30. :-*\n" +
			"<a> tak jsem se s tim zasranym realitakem hadala ze o tom datumu. No on je snad uplne vypatlanej!!\n" +
			"<b> co???\n" +
			"<a> presvedcoval mne ze 30. unora neexistuje a odmitnul se se mnou bavit.\n" +
			"<b> a tak domluvili jste se nejak?\n" +
			"<a> ne, odmitam se stakovym debilem bavit\n" +
			"<b> to jsem rad ze se tam nemusime chodit koukat :) ja ti rikal ze je to byt na prd. A ted se muzes podivat do kalendare na letosni unor :)\n" +
			"Komentář: týden se mnou nemluvila a měsíc jsem si nevrznul"));
	quotes.put(1, new Quote(2, "<A:> Koupila jsem na netu prsten z \"Pána prstenů\".\n" +
			"<A:> a podle délky dodání to vypadá že ho nesou z Mordoru.\n" +
			"<B:> Tak to buď ráda, že si neobjednala nic ze Star treku."));
	quotes.put(2, new Quote(3, "<a> a kto všetko idete?\n" +
			"<b> ja, lucka, michal a moja sestra s frajerom z IT\n" +
			"<a> tvoja sestra má frajera z IT?\n" +
			"<b> jj\n" +
			"<a> a ty ako informatik pre ňu nie si dostatočne odstrašujúci prípad?\n" +
			"<b> som\n" +
			"<b> ale IT je Itálie"));
	quotes.put(3, new Quote(4, "<a> prosimtě, co to tam bylo dneska u vás za smích, byl slyšet až nahoru :D\n" +
			"<b> to se smála máma :D jí volal zas nějakej průzkum a zrovna na něj neměla náladu\n" +
			"<a> a co udělala?\n" +
			"<b> No znělo to asi takhle:\n" +
			"<b> \"Dobrý den, tady průzkum pro firmu BlaBla, hovořím s paní <B>\"\n" +
			"<b> \"Tady je její pes.\"\n" +
			"<b> \"Cože?\"\n" +
			"<b> \"Haf! Haf!\"\n" +
			"<b> \"Tak se nezlobte, nashledanou....\"\n" +
			"<a> tak se na ně musí! :D\n" +
			"<b> to ona takhle dělá často, jednou se dokonce vydávala za rybičky :D"));
	quotes.put(4, new Quote(5, "<a> Tak jsem včera byl poprvé u té mé nové známosti.\n" +
			"<b> A co?\n" +
			"<a> Dohodli jsme se, že něco uvaříme a pak se podíváme na nějaký film.\n" +
			"<b> A bylo něco?\n" +
			"<a> Musím přiznat, že mě celkem zaskočila.\n" +
			"<a> Co prej bych raději viděl na stole. Jí nebo jídlo.\n" +
			"<b> Hustý. Cos jí řek?\n" +
			"<a> To záleží na tom, jak dobře umí vařit.\n" +
			"<b> A umí?\n" +
			"<a> Vařit? Asi ne."));
	quotes.put(5, new Quote(6, "<a> som bol dneska v prahe poriesit par veci\n" +
			"<a> kedze si netrufam ist tam autom isiel som klasicky vlakom a mhdckou, a jak som sedel v metre nastupila taka babka, dosla za typkom co sedel na mieste pre invalidov a zacala nanho hulakat co si to dovoluje ze on neni dochodca a jemu nic neni\n" +
			"<a> typek sa na nu pozrel, usmial sa, vyhrnul si rifle a odopol si nohu\n" +
			"<a> take ticho pocas celej cesty metrom som este nezazil"));
	quotes.put(6, new Quote(8, "13:00 <a> zákazník informován, že výpadky linky způsobuje zvýšený traffic na lince\n" +
			"13:14 <a> přišel e-mail, že zaznamenal DDoS útoky na port 53, prosí tedy o kompletní blokaci portu 53 na koncovém routeru, jestli je to možné\n" +
			"13:16 <b> možné to je, zablokujeme\n" +
			"13:30 <b> už by to mělo být hotové\n" +
			"13:32 <b> není náhodou port 53 pro DNS?\n" +
			"13:34 <c> je\n" +
			"13:35 <b> tak to jsem zvědav, za jak dlouho nám nahlásí nefunkční internet\n" +
			"15:27 <a> přišel e-mail od zákazníka. Nefunugje mu internet.\n" +
			"Komentář: Náš zákazník, náš pán."));
	quotes.put(7, new Quote(14, "<trubka> Nefunguje mi terminál.\n" +
			"<M> A zkusili jste ho restartovat?\n" +
			"<trubka> Už asi třikrát!!!\n" +
			"<M> Tak to zkuste ještě počtvrté.\n" +
			"<trubka> Jak se to dělá?"));
	quotes.put(8, new Quote(19, "<zákazník> Dobrý deň, chcela by som reklamovať televízor.\n" +
			"<podpora> Dobrý deň. Samozrejme je to možné, len poprosím opísať problém.\n" +
			"<zákazník> Včera večer, keď som pozerala Farmu tak mi nešla hlasitosť, potom nešiel ani vypnúť tak som ho musela mať celú noc zapnutý. Ďalší deň mi kolegiňa poradila že ho mam vybrať zo zástrčky. Poobede som chcela pozerať a nešiel zapnúť, tak mi kamarátka poradila že ho mam zapnúť gombíkom na televízore. Zapol sa, no stále nešla hlasitosť, prepínať a ani vypnúť tak som ho zas vytiahla zo zástrčky.\n" +
			"<podpora> Vyzerá to na závažnú poruchu bateriek v ovládači. Skúšali ste vymeniť baterky v ovládači?\n" +
			"<zákazník> Neskúšala a ani si to nebudem opravovať sama! Chcem teda reklamovať ovládač, stačí vám poslať ten alebo aj celý televízor?"));
	quotes.put(9, new Quote(25, "<a> prosímtě potřeboval bych pomoct s matikou..\n" +
			"<b> 7\n" +
			"<a> ha ha.. ne vážně, začali jsme brát limity, vim že je umíš..\n" +
			"<a> limita pro x->nekonecno z (14x^2-5x+52)/(2x^2+2)\n" +
			"<a> nějak nevim jak to zkrátit..\n" +
			"<b> 7\n" +
			"<a> hm tak fakt díky..\n" +
			"* a se obrátil na <c> ..\n" +
			"<a> čus, prosímtě <b> mi není schopnej pomoct, zvládáš limity?\n" +
			"<c> no snad jo, povídej\n" +
			"<a> limita pro x->nekonecno z (14x^2-5x+52)/(2x^2+2)\n" +
			"<c> 7\n" +
			"<a> jděte do prdele!\n" +
			"Komentář: Pro ty co si to nespočtou - vážně to 7 je.. ^^"));
  }

  public Quote getQuote(int quoteNumber) {
	return quotes.get(quoteNumber);
  }

  public int getQuotesCount() {
	return quotes.size();
  }

  private static class SingletonHolder {
	public static final QuoteRegister INSTANCE = new QuoteRegister();
  }

  public static QuoteRegister getInstance() {
	return SingletonHolder.INSTANCE;
  }
}