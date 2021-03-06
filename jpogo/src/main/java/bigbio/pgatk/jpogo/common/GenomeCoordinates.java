package bigbio.pgatk.jpogo.common;

//extension of coordinates, holds genomic coordinates.
public class GenomeCoordinates extends Coordinates<GenomeCoordinates> {

    private String transcriptid;
    private String exonid;

    //holds the chromosome.
    private Chromosome chr;
    //holds the scaffolding.
    private String chrscaf;
    //holds the strand.
    private Strand strand;
    //holds the frame.
    private Frame frame;

    public GenomeCoordinates(GenomeCoordinates obj) {
        super(obj);
        this.transcriptid = obj.transcriptid;
        this.exonid = obj.exonid;
        this.chr = obj.chr;
        this.chrscaf = obj.chrscaf;
        this.strand = obj.strand;
        this.frame = obj.frame;
    }

    public GenomeCoordinates() {
        super();
    }

    @Override
    public int compareTo(GenomeCoordinates otherInstance) {
        if (lessThan(otherInstance)) {
            return -1;
        } else if (otherInstance.lessThan(this)) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object otherInstance) {
        return compareTo((GenomeCoordinates) otherInstance) == 0;
    }

    private boolean comapre2(GenomeCoordinates lhs, GenomeCoordinates rhs) {
        if (lhs.chr == Chromosome.scaffold && rhs.chr == Chromosome.scaffold && lhs.chrscaf.equals(rhs.chrscaf)) {
            return lhs.start < rhs.start && lhs.end < rhs.end && lhs.end >= rhs.start;
        }
        if (lhs.chr == Chromosome.scaffold && rhs.chr == Chromosome.scaffold && !lhs.chrscaf.equals(rhs.chrscaf)) {
            return lhs.chrscaf.compareTo(rhs.chrscaf) < 0;
        }
        if (lhs.chr == Chromosome.scaffold && rhs.chr != Chromosome.scaffold) {
            return false;
        }
        if (lhs.chr != Chromosome.scaffold && rhs.chr == Chromosome.scaffold) {
            return true;
        }
        if (lhs.chr == rhs.chr) {
            return lhs.start < rhs.start && lhs.end < rhs.end && lhs.end >= rhs.start;
        }
        return lhs.chr.getValue() < rhs.chr.getValue();
    }

    public boolean equals2(GenomeCoordinates rhs) {
        return ((chr != Chromosome.scaffold && chr == rhs.chr) || (chr == Chromosome.scaffold && chrscaf.equals(rhs.chrscaf))) && start >= rhs.start && end <= rhs.end;
    }

    private boolean lessThan(GenomeCoordinates rhs) {
        if (chr == Chromosome.scaffold && rhs.chr == Chromosome.scaffold && chrscaf.equals(rhs.chrscaf)) {
            if (start == rhs.start) {
                return end < rhs.end;
            }
            return start < rhs.start;
        }
        if (chr == Chromosome.scaffold && rhs.chr == Chromosome.scaffold && !chrscaf.equals(rhs.chrscaf)) {
            return chrscaf.compareTo(rhs.chrscaf) < 0;
        }
        if (chr == Chromosome.scaffold && rhs.chr != Chromosome.scaffold) {
            return false;
        }
        if (chr != Chromosome.scaffold && rhs.chr == Chromosome.scaffold) {
            return true;
        }
        if (chr == rhs.chr) {
            if (start == rhs.start) {
                return end < rhs.end;
            }
            return start < rhs.start;
        }
        return chr.getValue() < rhs.chr.getValue();
    }

    public String getTranscriptid() {
        return transcriptid;
    }

    public void setTranscriptid(String transcriptid) {
        this.transcriptid = transcriptid;
    }

    public String getExonid() {
        return exonid;
    }

    public void setExonid(String exonid) {
        this.exonid = exonid;
    }

    public Chromosome getChr() {
        return chr;
    }

    public void setChr(Chromosome chr) {
        this.chr = chr;
    }

    public String getChrscaf() {
        return chrscaf;
    }

    public void setChrscaf(String chrscaf) {
        this.chrscaf = chrscaf;
    }

    public Strand getStrand() {
        return strand;
    }

    public void setStrand(Strand strand) {
        this.strand = strand;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    @Override
    public String toString() {
        return "GenomeCoordinates{" +
                "transcriptid='" + transcriptid + '\'' +
                ", exonid='" + exonid + '\'' +
                ", chr=" + chr +
                ", chrscaf='" + chrscaf + '\'' +
                ", strand=" + strand +
                ", frame=" + frame +
                ", start=" + start +
                ", end=" + end +
                ", Nterm=" + Nterm +
                ", Cterm=" + Cterm +
                '}';
    }
}