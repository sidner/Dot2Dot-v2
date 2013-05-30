/* Generated By:JJTree&JavaCC: Do not edit this line. Dot2Dot.java */
import java.io.*;


@SuppressWarnings("all")
public class Dot2Dot/*@bgen(jjtree)*/implements Dot2DotTreeConstants, Dot2DotConstants {/*@bgen(jjtree)*/
  protected JJTDot2DotState jjtree = new JJTDot2DotState();
public static void main(String args[]) throws ParseException,IOException {
          String dataLine = "";
        String temp = "";

        File inFile = new File(args[0]);
        BufferedReader bf = null;
                try {
                        bf = new BufferedReader(new InputStreamReader (new FileInputStream(inFile)));
                } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                }

                        while((dataLine=bf.readLine()) != null){
                                        temp += dataLine;
                         }
        try {
                        bf.close();
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

        InputStream input = new ByteArrayInputStream(temp.getBytes());

        Dot2Dot dot2dot = new Dot2Dot(input);
        SimpleNode root = dot2dot.DotGraph(); // devolve refer�ncia para o n� raiz da �rvore
        root.insereNos(""); // imprime no ecr� a �rvore
        root.drawGraph(args[0]);
        System.out.println("\u005cn\u005cn\u005cn");
        }

  final public SimpleNode DotGraph() throws ParseException {
                        /*@bgen(jjtree) DotGraph */
  ASTDotGraph jjtn000 = new ASTDotGraph(JJTDOTGRAPH);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      Graph();
                  jjtree.closeNodeScope(jjtn000, true);
                  jjtc000 = false;
                 {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
    throw new Error("Missing return statement in function");
  }

  final public void GraphID() throws ParseException {
                 /*@bgen(jjtree) GraphID */
                  ASTGraphID jjtn000 = new ASTGraphID(JJTGRAPHID);
                  boolean jjtc000 = true;
                  jjtree.openNodeScope(jjtn000);Token id = null;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        id = jj_consume_token(ID);
        break;
      default:
        jj_la1[0] = jj_gen;
        ;
      }
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    jjtn000.value = id.image;
        System.out.println("id.image" + " " + id.image);
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void Graph() throws ParseException {
               /*@bgen(jjtree) Graph */
               ASTGraph jjtn000 = new ASTGraph(JJTGRAPH);
               boolean jjtc000 = true;
               jjtree.openNodeScope(jjtn000);Token graph = null;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STRICT:
        jj_consume_token(STRICT);
        break;
      default:
        jj_la1[1] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GRAPH:
        graph = jj_consume_token(GRAPH);
        break;
      case DIGRAPH:
        graph = jj_consume_token(DIGRAPH);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      GraphID();
      jj_consume_token(LBRACKET);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GRAPH:
      case ATTR_SMT:
      case SUBGRAPH:
      case ID:
      case LBRACKET:
        Stmt_list();
        break;
      default:
        jj_la1[3] = jj_gen;
        ;
      }
      jj_consume_token(RBRACKET);
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    jjtn000.value = graph.image;
        System.out.println("graph.image" + " " + graph.image);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  final public void Stmt_list() throws ParseException {
    Stmt();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SEMICOLON:
      jj_consume_token(SEMICOLON);
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case GRAPH:
    case ATTR_SMT:
    case SUBGRAPH:
    case ID:
    case LBRACKET:
      Stmt_list();
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
  }

  final public void Stmt() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case GRAPH:
    case ATTR_SMT:
      Attr_smt();
      break;
    case SUBGRAPH:
    case LBRACKET:
      Subgraph();
      break;
    case ID:
      Nova();
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Nova() throws ParseException {
              /*@bgen(jjtree) Nova */
              ASTNova jjtn000 = new ASTNova(JJTNOVA);
              boolean jjtc000 = true;
              jjtree.openNodeScope(jjtn000);Token id = null;
    try {
      id = jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQUALS:
        jj_consume_token(EQUALS);
        jj_consume_token(ID);
        break;
      default:
        jj_la1[7] = jj_gen;
        Edge_stmt_temp();
      }
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    jjtn000.value = id.image;
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

/*
void Node_stmt(): {}
{
  Node_id()[Attr_list()]
}*/
  final public void Edge_stmt_temp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COLON:
      Port();
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EDGEOP_DIRECTED:
    case EDGEOP_UNDIRECTED:
      Temo();
      break;
    default:
      jj_la1[10] = jj_gen;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LSQBRACK:
        Attr_list();
        break;
      default:
        jj_la1[9] = jj_gen;
        ;
      }
    }
  }

  final public void Edge_stmt() throws ParseException {
                   /*@bgen(jjtree) Edge_stmt */
  ASTEdge_stmt jjtn000 = new ASTEdge_stmt(JJTEDGE_STMT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      Edge_stmt_temp();
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  final public void Attr_smt() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case GRAPH:
      jj_consume_token(GRAPH);
      break;
    case ATTR_SMT:
      jj_consume_token(ATTR_SMT);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    Attr_list();
  }

  final public void Node_id() throws ParseException {
                 /*@bgen(jjtree) Node_id */
                 ASTNode_id jjtn000 = new ASTNode_id(JJTNODE_ID);
                 boolean jjtc000 = true;
                 jjtree.openNodeScope(jjtn000);Token id;
    try {
      id = jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COLON:
        Port();
        break;
      default:
        jj_la1[12] = jj_gen;
        ;
      }
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    jjtn000.value = id.image;
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  final public void Attr_list() throws ParseException {
    jj_consume_token(LSQBRACK);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      Attr_type();
      break;
    default:
      jj_la1[13] = jj_gen;
      ;
    }
    jj_consume_token(RSQBRACK);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LSQBRACK:
      Attr_list();
      break;
    default:
      jj_la1[14] = jj_gen;
      ;
    }
  }

  final public void Attr_type() throws ParseException {
                  /*@bgen(jjtree) Attr_type */
                  ASTAttr_type jjtn000 = new ASTAttr_type(JJTATTR_TYPE);
                  boolean jjtc000 = true;
                  jjtree.openNodeScope(jjtn000);Token attr=null;
    try {
      attr = jj_consume_token(ID);
                       jjtn000.value = attr.image;
      A_list();
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  final public void A_list() throws ParseException {
                /*@bgen(jjtree) A_list */
                ASTA_list jjtn000 = new ASTA_list(JJTA_LIST);
                boolean jjtc000 = true;
                jjtree.openNodeScope(jjtn000);Token attr = null;
    try {
      jj_consume_token(EQUALS);
      attr = jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        jj_consume_token(COMMA);
        break;
      default:
        jj_la1[15] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        Attr_type();
        break;
      default:
        jj_la1[16] = jj_gen;
        ;
      }
           jjtree.closeNodeScope(jjtn000, true);
           jjtc000 = false;
           jjtn000.value = attr.image;
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  final public void Subgraph() throws ParseException {
                  /*@bgen(jjtree) Subgraph */
  ASTSubgraph jjtn000 = new ASTSubgraph(JJTSUBGRAPH);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SUBGRAPH:
        jj_consume_token(SUBGRAPH);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ID:
          jj_consume_token(ID);
          break;
        default:
          jj_la1[17] = jj_gen;
          ;
        }
        break;
      default:
        jj_la1[18] = jj_gen;
        ;
      }
      jj_consume_token(LBRACKET);
      Stmt_list();
      jj_consume_token(RBRACKET);
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  final public void Temo() throws ParseException {
    EdgeRHS();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LSQBRACK:
      Attr_list();
      break;
    default:
      jj_la1[19] = jj_gen;
      ;
    }
  }

  final public void EdgeRHS() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EDGEOP_DIRECTED:
      Directed();
      break;
    case EDGEOP_UNDIRECTED:
      Undirected();
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      Node_id();
      break;
    case SUBGRAPH:
    case LBRACKET:
      Subgraph();
      break;
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EDGEOP_DIRECTED:
    case EDGEOP_UNDIRECTED:
      EdgeRHS();
      break;
    default:
      jj_la1[22] = jj_gen;
      ;
    }
  }

  final public void Directed() throws ParseException {
                  /*@bgen(jjtree) Directed */
                  ASTDirected jjtn000 = new ASTDirected(JJTDIRECTED);
                  boolean jjtc000 = true;
                  jjtree.openNodeScope(jjtn000);Token directed = null;
    try {
      directed = jj_consume_token(EDGEOP_DIRECTED);
                                   jjtree.closeNodeScope(jjtn000, true);
                                   jjtc000 = false;
                                   jjtn000.value = directed.image;
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  final public void Undirected() throws ParseException {
                    /*@bgen(jjtree) Undirected */
                    ASTUndirected jjtn000 = new ASTUndirected(JJTUNDIRECTED);
                    boolean jjtc000 = true;
                    jjtree.openNodeScope(jjtn000);Token undirected = null;
    try {
      undirected = jj_consume_token(EDGEOP_UNDIRECTED);
                                       jjtree.closeNodeScope(jjtn000, true);
                                       jjtc000 = false;
                                       jjtn000.value = undirected.image;
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  final public void Port() throws ParseException {
              /*@bgen(jjtree) Port */
  ASTPort jjtn000 = new ASTPort(JJTPORT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        jj_consume_token(ID);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COLON:
          jj_consume_token(COLON);
          jj_consume_token(COMPASS_PT);
          break;
        default:
          jj_la1[23] = jj_gen;
          ;
        }
        break;
      case COMPASS_PT:
        jj_consume_token(COMPASS_PT);
        break;
      default:
        jj_la1[24] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  /** Generated Token Manager. */
  public Dot2DotTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[25];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2000,0x100,0xc0,0x42640,0x800000,0x42640,0x42640,0x1000000,0x400000,0x100000,0x30000,0x240,0x400000,0x2000,0x100000,0x2000000,0x2000,0x2000,0x400,0x100000,0x30000,0x42400,0x30000,0x400000,0x2800,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public Dot2Dot(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Dot2Dot(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new Dot2DotTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Dot2Dot(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new Dot2DotTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Dot2Dot(Dot2DotTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(Dot2DotTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[38];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 25; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 38; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
