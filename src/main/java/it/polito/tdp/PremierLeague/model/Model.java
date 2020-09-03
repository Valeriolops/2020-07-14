package it.polito.tdp.PremierLeague.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	
	
	private PremierLeagueDAO dao;
	private Graph<Team,DefaultWeightedEdge>grafo;
	private Map<Integer,Team>idMapTeam;
	private Map<Team,Integer>mappaTeamPunteggio;
	
	
	
	public Model() {
		dao= new PremierLeagueDAO();
		idMapTeam= new HashMap<Integer, Team>();
		dao.MAPlistAllTeams(idMapTeam);
		mappaTeamPunteggio= new HashMap<Team, Integer>();
		
		
		
		
		
	}
	
	
	
	
	public void creaGrafo() {
		grafo = new SimpleWeightedGraph<Team, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(grafo, dao.listAllTeams());
		
		
		
		
		
	}
	
	
	
	
	
	public int getNVertici () {
		
		
		return this.grafo.vertexSet().size();
		
		
		
		
		
		
		
	}
	
	public Map<Team,Integer> creaClassifica() {
		
		for(Team t : grafo.vertexSet()) {
			mappaTeamPunteggio.put(t, 0);
		}
		
		
		for(Match m : dao.listAllMatches()) {
			Team casa = idMapTeam.get(m.teamHomeID);
			Team ospite = idMapTeam.get(m.getTeamAwayID());
			Integer risultato=m.getReaultOfTeamHome();
			
			if(risultato.compareTo(1)==0) {
			//	Integer punteggioIniziale= casa.getPunteggioFinale();
			//	casa.setPunteggioFinale(punteggioIniziale+3);
				mappaTeamPunteggio.put(casa, mappaTeamPunteggio.get(casa)+3);
				
				
			}
			if(risultato.compareTo(-1)==0) {
			//	Integer punteggioIniziale= ospite.getPunteggioFinale();
			//	ospite.setPunteggioFinale(punteggioIniziale+3);
				mappaTeamPunteggio.put(ospite, mappaTeamPunteggio.get(ospite)+3);
				
			}
			if(risultato.compareTo(0)==0) {
			//	Integer punteggioInizialeCasa=casa.getPunteggioFinale();
			//	casa.setPunteggioFinale(punteggioInizialeCasa+1);
			//	Integer punteggioInizialeOspite=ospite.getPunteggioFinale();
			//	ospite.setPunteggioFinale(punteggioInizialeOspite+1);
				mappaTeamPunteggio.put(casa, mappaTeamPunteggio.get(casa)+1);
				mappaTeamPunteggio.put(ospite, mappaTeamPunteggio.get(ospite)+1);
				
				
			}
			
		}
		
			return this.mappaTeamPunteggio;
			
	
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

